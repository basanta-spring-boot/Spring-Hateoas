package com.basant.spring.hateoas.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basant.spring.hateoas.api.dto.Employee;

@RestController
@RequestMapping("/hateoasAPI")
public class EmployeeController {
	List<Employee> employees = new ArrayList<Employee>();

	@GetMapping(value = "/getEmployees", produces = MediaTypes.HAL_JSON_VALUE)
	public List<Employee> getEmployees() {
		Employee emp1 = new Employee("EMP4848", "Basanta", "FSD", 10000);
		emp1.add(getHateousLink(emp1));
		Employee emp2 = new Employee("EMP6969", "Santosh", "UID", 20000);
		emp2.add(getHateousLink(emp2));
		employees.add(emp1);
		employees.add(emp2);
		return employees;
	}

	// it will returns the link which is your one end point of controller class
	private Link getHateousLink(Employee employee) {
		Link link = ControllerLinkBuilder.linkTo(EmployeeController.class).slash("findBy/" + employee.getName())
				.withSelfRel();
		return link;
	}

	@GetMapping("/findBy/{name}")
	public Employee getEmployeeByName(@PathVariable String name) {
		return employees.stream().filter(e -> e.getName().equalsIgnoreCase(name)).findAny().get();
	}
}
