package com.microservicios8.workstation.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicios8.workstation.app.entities.WorkStation;
import com.mircoservicios8.workstation.app.service.WorkStationService;
@CrossOrigin
@RestController
@RequestMapping("/v1/workstations")
public class WorkStationController {
	
	@Autowired
	 WorkStationService workstationService;

	//obtener todos los workstation
	  @RequestMapping
	public ResponseEntity <List<WorkStation>> getAllWorkstation() {
		List<WorkStation> lista = workstationService.retrieveAll();
		//return workstationService.retrieveAll();
		return new  ResponseEntity <List<WorkStation>>(lista,HttpStatus.OK);
		
	}
	//obtener todos workstation por el id
	@GetMapping("/{workstationId}")
	public WorkStation getWorkstation(@PathVariable long workstationId) {
		return workstationService.retrieveById(workstationId);
	}

	//guardar workstation
	@PostMapping
	public WorkStation postWorkStation(@RequestBody WorkStation workstation) {
		return workstationService.register(workstation);
	}
	//actualizar usuario
	@PutMapping("/{workestationid}")
	public WorkStation actualizarworkstation(@PathVariable long workestationid, @RequestBody WorkStation ws) {
		ws.setId(workestationid);	
		return workstationService.update(ws);
	}
	//borrar workstation
	@DeleteMapping("/{workestationid}")
	public WorkStation borrarworkstation(@PathVariable long workestationid) {
		
		return workstationService.delete(workstationService.retrieveById(workestationid));
		
	}
	//obtiene la lista por vendor
	@GetMapping("/vendors/{vendor}")
	public List<WorkStation> getbyvendor(@PathVariable String vendor){
		
		return workstationService.retrieveByVendor(vendor);
	}
	//obtiene por serialnumber
	@GetMapping("/serial/{serialnumber}")
	public List<WorkStation> getbyserialnumber(@PathVariable String serialnumber){
		
		return workstationService.retrieveByFacilitiesSerialNumber(serialnumber);
	}
	//obtiene por employeeid
	@GetMapping("/employees/{employeeid}")
	
	public WorkStation  getbyemployeid(@PathVariable long employeeid) {
		
		return workstationService.retrieveByEmployeeId(employeeid);
		
	}
	
	
	
	
}
