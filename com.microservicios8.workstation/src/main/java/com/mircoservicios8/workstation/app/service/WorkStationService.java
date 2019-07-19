package com.mircoservicios8.workstation.app.service;

import java.util.List;

import com.microservicios8.workstation.app.entities.WorkStation;



public interface WorkStationService {

	WorkStation retrieveById(Long id);//ok

	List<WorkStation> retrieveAll();//ok

	WorkStation register(WorkStation workstation);//ok-validar idemployee

	WorkStation update(WorkStation workstation);//ok

	WorkStation delete(WorkStation workstation);//ok

	List<WorkStation> retrieveByVendor(String vendor);//ok

	List<WorkStation> retrieveByFacilitiesSerialNumber(String facilitiesSerialNumber);//oki

	//List<WorkStation>  retrieveByEmployeeId(long employeeId);//oki doki
	WorkStation retrieveByEmployeeId(long employeeId);//oki doki
}