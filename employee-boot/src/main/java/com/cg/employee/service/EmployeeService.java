package com.cg.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.employee.dto.Employee;
import com.cg.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee findById(int id) {
		return employeeRepository.findById(id).orElse(null);
	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public Employee findByName(String name) {
		return employeeRepository.findByNameIgnoreCase(name);
	}

	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public List<Employee> findByDepartment(String department) {
		return employeeRepository.findByDepartment(department);
	}

	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
	}

}
