package com.microservicios8.employee.cliente;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.microservicios8.employee.entities.WorkStation;

@Service
public class ClientePeticion {

	private static final String URL = "http://localhost:9091/workstation/v1/workstations/";
	
	
	
	public String tirapeticionGet(String url) {
		String resultado="";
	    final String uri = URL+url;
	     try {
	    	 
	    	RestTemplate restTemplate = new RestTemplate(); 
	 	    HttpHeaders headers = new HttpHeaders();
	 	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	 	    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	 	     
	 	    ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
	 	     
	 	    
	 	    switch(result.getStatusCodeValue()) {
	 	    
	 	    case 200:
	 	    	System.out.println("Result " + result.getBody());
	 	    	resultado=result.getBody();
	 	    	return resultado;
	 	   
	 	    
	 	    
	 	    case 400:
	 	    	System.out.println("No hay nada que mostrar");
	 	    	return resultado;
	 	    
	 	    
	 	    	default:
	 	    		return resultado;
	 	    }
	 	    
	 	    
	 	    
	 	    
//	 	    if(result.getStatusCodeValue()==400) {
//	 	    	System.out.println("No hay nada que mostrar");
//	 	    	return "";
//	 	    }
//	 	    
//	 	    if(result.getStatusCodeValue()==200) {
//	 	    	System.out.println("Ahuevo entro al if");
//	 	    	System.out.println("Result " + result.getBody());
//	 	    	resultado=result.getBody();
//	 	    return resultado;
//	 	    }
//	 	    	
//	    	return resultado; 
	     }catch(Exception e) {
	    	 //System.out.println("No hay nada que mostrar");
	 	    	return resultado;
	     }
	   
	}
	
	public String tirarpost( WorkStation a) {
		String resultado="";
		final String uri = URL;
	     try {
	    	 ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
	    	 String json= ow.writeValueAsString(a);
	    	 
	    	RestTemplate restTemplate = new RestTemplate(); 
	 	    HttpHeaders headers = new HttpHeaders();
	 	    headers.setContentType(MediaType.APPLICATION_JSON);
	 	    HttpEntity<String> entity = new HttpEntity<String>(json, headers);
	 	    //ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);
	 	    resultado = restTemplate.postForObject(uri, entity, String.class);
		
	 	   return resultado;
	}catch(Exception e) {
   	 System.out.println("No hay nada que mostrar catch");
  	return resultado;
		}
	}
	
	public String tirarput(String url, WorkStation a) {
		
		String resultado="";
	    final String uri = URL+url;
	    
	     try {
	    	 ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
	    	 String json= ow.writeValueAsString(a);
	    	 
	    	RestTemplate restTemplate = new RestTemplate(); 
	 	    HttpHeaders headers = new HttpHeaders();
	 	   headers.setContentType(MediaType.APPLICATION_JSON);
	 	    HttpEntity<String> entity = new HttpEntity<String>(json, headers);
	 	     
	 	    ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.PUT, entity, String.class);
	 	     
	 	    
	 	    switch(result.getStatusCodeValue()) {
	 	    
	 	    case 200:
	 	    	System.out.println("Result " + result.getBody());
	 	    	resultado=result.getBody();
	 	    	return resultado;
	 	   
	 	    
	 	    
	 	    case 400:
	 	    	System.out.println("No hay nada que mostrar");
	 	    	return resultado;
	 	    
	 	    
	 	    	default:
	 	    		return resultado;
	 	    }
	 	    
	 	    
	 	    
	 	    
//	 	    if(result.getStatusCodeValue()==400) {
//	 	    	System.out.println("No hay nada que mostrar");
//	 	    	return "";
//	 	    }
//	 	    
//	 	    if(result.getStatusCodeValue()==200) {
//	 	    	System.out.println("Ahuevo entro al if");
//	 	    	System.out.println("Result " + result.getBody());
//	 	    	resultado=result.getBody();
//	 	    return resultado;
//	 	    }
//	 	    	
//	    	return resultado; 
	     }catch(Exception e) {
	    	 //System.out.println("No hay nada que mostrar");
	 	    	return resultado;
	     }
	   
	}
	public String tirapeticionDelete(String url) {
		String resultado="";
	    final String uri = URL+url;
	     try {
	    	 
	    	RestTemplate restTemplate = new RestTemplate(); 
	 	    HttpHeaders headers = new HttpHeaders();
	 	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	 	    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	 	     
	 	    ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, entity, String.class);
	 	     
	 	    
	 	    switch(result.getStatusCodeValue()) {
	 	    
	 	    case 200:
	 	    	System.out.println("Result " + result.getBody());
	 	    	resultado=result.getBody();
	 	    	return resultado;
	 	    	    
	 	    case 400:
	 	    	System.out.println("No hay nada que mostrar");
	 	    	return resultado;
	 	    
	 	    
	 	    	default:
	 	    		return resultado;
	 	    }
	 	    
	 	    
	 	    
	 	    
//	 	    if(result.getStatusCodeValue()==400) {
//	 	    	System.out.println("No hay nada que mostrar");
//	 	    	return "";
//	 	    }
//	 	    
//	 	    if(result.getStatusCodeValue()==200) {
//	 	    	System.out.println("Ahuevo entro al if");
//	 	    	System.out.println("Result " + result.getBody());
//	 	    	resultado=result.getBody();
//	 	    return resultado;
//	 	    }
//	 	    	
//	    	return resultado; 
	     }catch(Exception e) {
	    	 //System.out.println("No hay nada que mostrar");
	 	    	return resultado;
	     }
	   
	}
	
}
