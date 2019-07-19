package com.microservicios8.workstation.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservicios8.workstation.app.entities.WorkStation;

public interface WorkStationRepository extends JpaRepository<WorkStation, Long>  {

	
	List<WorkStation> findByVendor(String vendor);

	List<WorkStation> findByFacilitiesSerialNumber(String facilitiesSerialNumber);

	//List<WorkStation> findByEmployeeId(long employeeId);
	WorkStation findByEmployeeId(long employeeId);
	
}
