package com.microservicios8.workstation.app.service.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.microservicios8.workstation.app.entities.WorkStation;
import com.microservicios8.workstation.app.exceptions.WorkstationNotFoundException;
import com.microservicios8.workstation.app.repository.WorkStationRepository;
import com.mircoservicios8.workstation.app.service.WorkStationService;

@Service
public class WorkStationServiceImp implements WorkStationService{
	
	@Autowired
	 WorkStationRepository workstationRepository;

	@Override
	public WorkStation retrieveById(Long id) {
		return workstationRepository.findById(id)
				.orElseThrow(() -> new WorkstationNotFoundException("Workstation not found"));
	}

	@Override
	public List<WorkStation> retrieveAll() {
		return workstationRepository.findAll();
	}

	@Override
	public WorkStation register(WorkStation workstation) {
		//validar si el id del empleado existe
		workstation = workstationRepository.save(workstation);
		
		return workstation;
	}

	@Override
	public WorkStation update(WorkStation workstation) {
		return register(workstation);
	}

	@Override
	public WorkStation delete(WorkStation workstation) {
		workstationRepository.delete(workstation);
		
		return workstation;
	}

	@Override
	public List<WorkStation> retrieveByVendor(String vendor) {
		return workstationRepository.findByVendor(vendor);
	}

	@Override
	public List<WorkStation> retrieveByFacilitiesSerialNumber(String facilitiesSerialNumber) {
		return workstationRepository.findByFacilitiesSerialNumber(facilitiesSerialNumber);
	}

	@Override
	public WorkStation retrieveByEmployeeId(long employeeId) {
		
		WorkStation a = workstationRepository.findByEmployeeId(employeeId);
		
		// List<WorkStation> a = workstationRepository.findByEmployeeId(employeeId);
		
		
		if(a!=null){
			return a;		
		}
		else {
			throw new WorkstationNotFoundException("Workstation not found");
		}
		
		
//		if(!a.isEmpty()){
//		return a;		
//	}
//	else {
//		throw new WorkstationNotFoundException("Workstation not found");
//	}
//	}
	}

}
