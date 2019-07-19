package com.microservicios8.workstation.app.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//entidad
@Entity
//constructor sin argumentos
@NoArgsConstructor
//constructor con argumentos
@AllArgsConstructor
@Builder
public class WorkStation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long id;
	
	public String vendor;

	public String model;

	public String facilitiesSerialNumber;

	public long employeeId;

}
