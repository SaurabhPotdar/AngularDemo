package com.cg.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.cg.employee.dto.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	public Employee findByName(@Param("name") String name);

	public List<Employee> findByDepartment(@Param("department") String department);

}
