package com.cg.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.employee.dto.Employee;
import com.cg.employee.service.EmployeeService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/employees")
@Log4j2
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping(value = "")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
		try {
			employee.setName(employee.getName().toUpperCase());
			employee.setDepartment(employee.getDepartment().toUpperCase());
			return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findById(@PathVariable int id) {
		log.info("Inside findById");
		Employee employee = employeeService.findById(id);
		if (employee != null)
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		return new ResponseEntity<String>("No employee found", HttpStatus.BAD_REQUEST);
	}

	// To find by using multiple parameters, we just create one controller method
	@GetMapping(value = "find")
	public ResponseEntity<?> findByDepartmentOrName(@RequestParam(required = false) String department,
			@RequestParam(required = false) String name) {
		if(department==null && name==null) {
			return new ResponseEntity<String>("No query param provided", HttpStatus.BAD_REQUEST);
		}
		if (department != null) {
			department = department.toUpperCase();
			List<Employee> employee = employeeService.findByDepartment(department);
			if (employee != null)
				return new ResponseEntity<List<Employee>>(employee, HttpStatus.OK);
		}
		if (name != null) {
			name = name.toUpperCase();
			Employee employee = employeeService.findByName(name);
			if (employee != null)
				return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		}
		return new ResponseEntity<String>("No employee found", HttpStatus.BAD_REQUEST);
	}

	@GetMapping(value = "")
	public ResponseEntity<?> getAllEmployees() {
		List<Employee> employees = employeeService.getAllEmployees();
		if (employees.size() != 0)
			return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
		return new ResponseEntity<String>("No employees found", HttpStatus.BAD_REQUEST);
	}

	@PutMapping(value = "")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
		try {
			employee.setName(employee.getName().toUpperCase());
			employee.setDepartment(employee.getDepartment().toUpperCase());
			return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}
