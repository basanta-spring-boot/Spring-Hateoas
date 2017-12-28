package com.basant.spring.hateoas.api.dto;

import org.springframework.hateoas.ResourceSupport;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class Employee extends ResourceSupport {

	private String employeeId;
	private String name;
	private String profession;
	private double salary;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

}
