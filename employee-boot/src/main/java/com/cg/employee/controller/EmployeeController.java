package com.cg.employee.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.employee.dto.Employee;
import com.cg.employee.service.EmployeeService;

import lombok.extern.log4j.Log4j2;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/employees")
@Log4j2
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping(value = "")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
		try {
			log.info(employee);
			return new ResponseEntity<Employee>(employeeService.addEmployee(employee), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findById(@PathVariable int id) {
		log.info("Id: " + id);
		Employee employee = employeeService.findById(id);
		if (employee != null)
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		return new ResponseEntity<String>("No employee found", HttpStatus.BAD_REQUEST);
	}

	// Finding by using multiple parameters,using just one controller method
	@GetMapping(value = "find")
	public ResponseEntity<?> findByDepartmentOrName(@RequestParam(required = false) String department,
			@RequestParam(required = false) String name) {
		log.info("Department: " + department);
		log.info("Name: " + name);
		if (department == null && name == null) {
			return new ResponseEntity<String>("No query param provided", HttpStatus.BAD_REQUEST);
		}
		if (department != null) {
			List<Employee> employee = employeeService.findByDepartment(department);
			if (employee != null)
				return new ResponseEntity<List<Employee>>(employee, HttpStatus.OK);
		}
		if (name != null) {
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
			log.info(employee);
			return new ResponseEntity<Employee>(employeeService.addEmployee(employee), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
		try {
			log.info(id);
			return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}
