package com.employee.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.VO.response.CommonEmployeeResponse;
import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

@RestController
@Validated
public class EmployeeController {
	
	Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/save")
	public ResponseEntity<CommonEmployeeResponse> saveEmployee(@Valid @RequestBody Employee emp) {
		logger.trace("Inside saveEmployee controller");
		CommonEmployeeResponse employeeResponse = employeeService.saveEmployee(emp);
		return new ResponseEntity<>(employeeResponse, HttpStatus.OK);
	}

}
