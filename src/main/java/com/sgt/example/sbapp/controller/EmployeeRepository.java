package com.sgt.example.sbapp.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 

 

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Long> {

}
