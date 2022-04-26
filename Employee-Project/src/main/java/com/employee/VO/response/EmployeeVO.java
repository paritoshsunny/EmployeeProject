package com.employee.VO.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeVO {
	
	private String empId;
	private String firstName;
	private String lastName;
	private String department;
	private String designation;
	private String email;
	private String salary;
	private List<AddressVO> addresses;
}
