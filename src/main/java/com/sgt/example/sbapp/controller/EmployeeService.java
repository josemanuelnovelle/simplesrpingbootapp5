package com.sgt.example.sbapp.controller;

import java.util.List;

import org.postgresql.util.PSQLException;
 

public interface EmployeeService {
	
	List<Employee> servicefindAll() throws PSQLException;
	Employee  serviceEmployee(Long employeeId) throws ResourceNotFoundException;
	Employee  serviceEmployeesave(Employee employee);
	void serviceEmployeedelete(Employee employee);
}
