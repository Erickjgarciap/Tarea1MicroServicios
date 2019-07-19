package com.microservicios8.employee.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
//entidad
@Entity
//constructor sin argumentos
@NoArgsConstructor
//constructor con argumentos
@AllArgsConstructor
@Builder
@ToString

public class WorkStation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long id;
	
	public String vendor;

	public String model;

	public String facilitiesSerialNumber;

	public long employeeId;

}
