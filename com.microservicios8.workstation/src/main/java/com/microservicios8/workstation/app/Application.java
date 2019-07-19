package com.microservicios8.workstation.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.microservicios8.workstation.app.entities.WorkStation;
import com.microservicios8.workstation.app.repository.WorkStationRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	public WorkStationRepository workstationRepository;
	
	public Application(WorkStationRepository workstationRepository) {
		this.workstationRepository = workstationRepository;
		
	}
	@Bean
	public CommandLineRunner startup() {
		
		return (args) -> {
			
			WorkStation workstation = WorkStation.builder().vendor("Mac").model("Mac Book Pro 15 Retina")
					.facilitiesSerialNumber("100").build();

			workstationRepository.save(workstation);

			workstation = WorkStation.builder().vendor("Mac").model("Mac Book Air 13")
					.facilitiesSerialNumber("101").build();

			workstationRepository.save(workstation);

			workstation = WorkStation.builder().vendor("Mac").model("iMac Pro 25 Retina")
					.facilitiesSerialNumber("102").build();

			workstationRepository.save(workstation);
		};
	}
}
