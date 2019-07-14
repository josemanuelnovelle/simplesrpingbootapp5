package com.sgt.example.sbapp.controller;

 
import java.sql.SQLException;
import java.util.List;

import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

 
 



@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> servicefindAll() {
		List<Employee> e = null;
	 
		 employeeRepository.findAll();
		 
	 
		return e;
	}

	@Override
	public Employee serviceEmployee(Long employeeId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		return employee;
	}

	@Override
	public Employee serviceEmployeesave(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public void serviceEmployeedelete(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepository.delete(employee);
	}
	
	
	
	
}
