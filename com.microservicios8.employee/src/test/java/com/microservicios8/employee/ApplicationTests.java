package com.microservicios8.employee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.microservicios8.employee.entities.WorkStation;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Test
	public void contextLoads() {
		ObjectMapper objectMapper = new ObjectMapper();
		
		

//			List<WorkStation> cv = new ArrayList<>();
//			
//			String result = getEmployees();
//			
//			System.out.print("Que traigo como resultado " + result.toString()+"\n");	
//			
//			if(result.isEmpty()) {
//				System.out.print("Esta madre esta vacia " +"\n");
//			}
//			else {
//				
//				WorkStation a;
//				try {
//					a = objectMapper.readValue(result, WorkStation.class);
//					System.out.print("Mapeo de respuesta " + a.toString());				
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
		WorkStation b = new WorkStation();
		
		b.setVendor("a");
		b.setModel("z");
		b.setFacilitiesSerialNumber("123432");
		b.setEmployeeId(10);
		
		//tirapeticionPost("",b);
		//tirapeticionPut("",b);
		tirapeticionDelete("");
	}

	
	private static String getEmployees() {
		String resultado="";
	    final String uri = "http://localhost:9091/workstation/v1/workstations/1";
	     try {
	    	 RestTemplate restTemplate = new RestTemplate();
		     
	 	    HttpHeaders headers = new HttpHeaders();
	 	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	 	    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	 	     
	 	    ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
	 	     
	 	    if(result.getStatusCodeValue()==400) {
	 	    	System.out.println("No hay nada que mostrar");
	 	    	return "";
	 	    }
	 	    
	 	    if(result.getStatusCodeValue()==200) {
	 	    	System.out.println("Ahuevo entro al if");
	 	    	System.out.println("Result " + result.getBody());
	 	    	resultado=result.getBody();
	 	    return resultado;
	 	    }
	 	    	
	    	return resultado; 
	     }catch(Exception e) {
	    	 //System.out.println("No hay nada que mostrar");
	 	    	return resultado;
	     }
	   
	}
	public void tirapeticionPost(String url, WorkStation a) {
		String resultado="";
	    final String uri = "http://localhost:9091/workstation/v1/workstations";
	     try {
	    	 ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
	    	 String json= ow.writeValueAsString(a);
	    	 
	    	RestTemplate restTemplate = new RestTemplate(); 
	 	    HttpHeaders headers = new HttpHeaders();
	 	    headers.setContentType(MediaType.APPLICATION_JSON);
	 	    HttpEntity<String> entity = new HttpEntity<String>(json, headers);
	 	    ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);
	 	    //resultado = restTemplate.postForObject(uri, entity, String.class);
	 	  
	 	    System.out.println("hahaha  " + resultado);
//	 	   switch(result.getStatusCodeValue()) {
//	 	    
//	 	    case 200:
//	 	    	System.out.println("Result " + result.getBody());
//	 	    	resultado=result.getBody();
//	 	    	return resultado;
//	 	   
//	 	    
//	 	    
//	 	    case 400:
//	 	    	System.out.println("No hay nada que mostrar");
//	 	    	return resultado;
//	 	    
//	 	    
//	 	    	default:
//	 	    		return resultado;
//	 	    }
	 	    
	     }catch(Exception e) {
	    	 System.out.println("No hay nada que mostrar catch");
	 	    	//return resultado;
	     }
	   
	}
	
	public void tirapeticionPut(String url, WorkStation a) {
		String resultado="";
	    final String uri = "http://localhost:9091/workstation/v1/workstations/1";
	     try {
	    	 ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
	    	 String json= ow.writeValueAsString(a);
	    	 
	    	RestTemplate restTemplate = new RestTemplate(); 
	 	    HttpHeaders headers = new HttpHeaders();
	 	    headers.setContentType(MediaType.APPLICATION_JSON);
	 	    HttpEntity<String> entity = new HttpEntity<String>(json, headers);
	 	    ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.PUT, entity, String.class);
	 	   // resultado = restTemplate.put(uri, entity, String.class);
	 	  
	 	    System.out.println("hahaha  " + result.getStatusCodeValue());
//	 	   switch(result.getStatusCodeValue()) {
//	 	    
//	 	    case 200:
//	 	    	System.out.println("Result " + result.getBody());
//	 	    	resultado=result.getBody();
//	 	    	return resultado;
//	 	   
//	 	    
//	 	    
//	 	    case 400:
//	 	    	System.out.println("No hay nada que mostrar");
//	 	    	return resultado;
//	 	    
//	 	    
//	 	    	default:
//	 	    		return resultado;
//	 	    }
	 	    
	     }catch(Exception e) {
	    	 System.out.println("No hay nada que mostrar catch");
	 	    	//return resultado;
	     }
	   
	}
	public void tirapeticionDelete(String url) {
		String resultado="";
	    final String uri = "http://localhost:9091/workstation/v1/workstations/1";
	     try {

	    	 
	    	RestTemplate restTemplate = new RestTemplate(); 
	 	    HttpHeaders headers = new HttpHeaders();
	 	    headers.setContentType(MediaType.APPLICATION_JSON);
	 	    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	 	    ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, entity, String.class);
	 	   // resultado = restTemplate.put(uri, entity, String.class);
	 	  
	 	    System.out.println("hahaha  " + result.getStatusCodeValue());
//	 	   switch(result.getStatusCodeValue()) {
//	 	    
//	 	    case 200:
//	 	    	System.out.println("Result " + result.getBody());
//	 	    	resultado=result.getBody();
//	 	    	return resultado;
//	 	   
//	 	    
//	 	    
//	 	    case 400:
//	 	    	System.out.println("No hay nada que mostrar");
//	 	    	return resultado;
//	 	    
//	 	    
//	 	    	default:
//	 	    		return resultado;
//	 	    }
	 	    
	     }catch(Exception e) {
	    	 System.out.println("No hay nada que mostrar catch");
	 	    	//return resultado;
	     }
	   
	}
	
}


