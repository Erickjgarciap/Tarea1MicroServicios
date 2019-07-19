package com.microservicios8.employee.service.imp;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservicios8.employee.cliente.ClientePeticion;
import com.microservicios8.employee.entities.Employee;
import com.microservicios8.employee.entities.WorkStation;
import com.microservicios8.employee.exceptions.EmployeeNotFoundException;
import com.microservicios8.employee.repository.EmployeeRepository;
import com.microservicios8.employee.service.EmployeeService;

@Service
public class EmployeeServiceImp implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ClientePeticion cliente;
	
	@Override
	public List<Employee> retrieveAll() {
		ObjectMapper objectMapper = new ObjectMapper();
		
		List<Employee> li =employeeRepository.findAll();
		
		for(Employee em : li) {
			String ws =cliente.tirapeticionGet("employees/"+em.getId()+"");
			
			if(ws.isEmpty()) {
				System.out.print("Esta madre esta vacia " +"\n");
			}
			else {
				WorkStation workstation;
				//List<WorkStation> workstation;
				try {
					workstation = objectMapper.readValue(ws, WorkStation.class);
					//workstation = objectMapper.readValue(ws, new TypeReference<List<WorkStation>>(){});
					System.out.print("Mapeo de respuesta " + workstation.toString());	
					
						
						em.setWorkstation(workstation);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		//return employeeRepository.findAll();
		
		return li;
	}
	
	@Override
	public Employee retrieveById(Long id) {
		//employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
		System.out.println("Entro y muestro");
		ObjectMapper objectMapper = new ObjectMapper();
		
		Employee a = employeeRepository.findById(id).get();
		
		String ws =cliente.tirapeticionGet("employees/"+a.getId()+"");
		
		if(ws.isEmpty()) {
			System.out.print("Esta madre esta vacia " +"\n");
			
			return a;
		}
		else {
			WorkStation workstation;
			try {
				workstation = objectMapper.readValue(ws,WorkStation.class);
				System.out.print("Mapeo de respuesta " + workstation.toString());	
				
				if(workstation!=null) {
					
	
					a.setWorkstation(workstation);
				}
				return a;
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		return a;
	}

	@Override
	public Employee register(Employee employee) {
		//mandar a llamar al servicio de workestation
		//valido si me mandan solo el id
		//valido que exista el workstation asi como que no este ya asignado
		ObjectMapper objectMapper = new ObjectMapper();
		if(employee.getWorkstation()!=null) {
			if( employee.getWorkstation().getId() != 0 ) {
				String ws =cliente.tirapeticionGet(employee.getWorkstation().getId()+"");
				 ws =cliente.tirapeticionGet(employee.getWorkstation().getId()+"");
				if(ws.isEmpty()) { //indica que no existe el workstation y hay que crearlo
					System.out.print("Esta madre esta vacia " +"\n");
					
					Employee em = employeeRepository.save(employee);
					
					WorkStation wos = employee.getWorkstation();
					wos.setEmployeeId(em.getId());
					String ws1 = cliente.tirarpost(wos);
					
					try {
						wos = objectMapper.readValue(ws1, WorkStation.class);
						
					} catch (JsonParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					
					} catch (JsonMappingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					em.setWorkstation(wos);
					//return employeeRepository.save(employee);
					return em;
				}
			}else{//si no recibo id tomo lo que venga en el workstation
				Employee em = employeeRepository.save(employee);
				WorkStation wos = employee.getWorkstation();
				wos.setEmployeeId(em.getId());
				String ws1 = cliente.tirarpost(wos);
				try {
					wos = objectMapper.readValue(ws1, WorkStation.class);
					em.setWorkstation(wos);
					
				} catch (JsonParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
				//return employeeRepository.save(employee);
				return em;
			}
			
		}			
		return employeeRepository.save(employee);
	}

	@Override
	public Employee update(Employee employee) {
		//mandar a llamar al servicio de workestation
		ObjectMapper objectMapper = new ObjectMapper();
		if(employee.getWorkstation()!=null) {
			if( employee.getWorkstation().getId() != 0) {
				String ws =cliente.tirapeticionGet(employee.getWorkstation().getId()+"");//si existe el work
				if(ws.isEmpty() ) { //indica que el workstation no existe o ya esta asignado
					System.out.print("Esta madre esta vacia " +"\n");
	
					//return employeeRepository.save(employee);
					throw new EmployeeNotFoundException("EL id del workstation no existe ");
					//return 
				}else {
					System.out.print("Si sexiste el workstation " +"\n");
					Employee em = employee;
					WorkStation workstation;
					try {
						workstation = objectMapper.readValue(ws, WorkStation.class);
						System.out.print("Mapeo de respuesta " + workstation.toString());	
						if(workstation.getEmployeeId() == 0) {
							System.out.print("1" +"\n");
							 em.setWorkstation(workstation);
							 System.out.print("2" +"\n");
							 workstation.setEmployeeId(em.getId());
							 System.out.print("3" +"\n");
							 String wsput =cliente.tirarput(""+workstation.getId(), workstation);
							 System.out.print("4" +"\n");
							 //workstation = objectMapper.readValue(wsput, WorkStation.class);
							 System.out.print("que madres trae wsput" + wsput +"\n");
							 em.setWorkstation(workstation);
							
							 return employeeRepository.save(em);
						}
						else {
							
							throw new EmployeeNotFoundException("EL id del workstation ya esta asignado");
						}
							
				
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				   }
				}
			}
		
		
		
		return employeeRepository.save(employee);
	}

	@Override
	public Employee delete(Employee employee) {
		ObjectMapper objectMapper = new ObjectMapper();
		String ws =cliente.tirapeticionGet("employees/"+employee.getId()+"");
		
		if(ws.isEmpty()) {
			System.out.print("Esta madre esta vacia " +"\n");
			employeeRepository.delete(employee);
			return employee;
		}else {
			WorkStation workstation;
			//List<WorkStation> workstation;
			try {
				workstation = objectMapper.readValue(ws, WorkStation.class);
				//workstation = objectMapper.readValue(ws, new TypeReference<List<WorkStation>>(){});
				System.out.print("Mapeo de respuesta " + workstation.toString());	
//				for(WorkStation c: workstation) {
//					c.setEmployeeId(0);
//					cliente.tirarput(""+c.getId(), c);
//				}
				cliente.tirarput(""+workstation.getId(), workstation);
				employeeRepository.delete(employee);
				return employee;
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		employeeRepository.delete(employee);
		return employee;
	}



}
