package com.employee.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Employee implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long empId;
	
	@NotNull(message = "First name is mandatory")
	@NotEmpty(message = "Please Enter firstName")
	@Size(min=2,max=40,message="First name should be mininum 2 char and max 25 char long")
	private String firstName;
	
	@NotNull(message = "Last name is mandatory")
	@NotEmpty(message = "Please Enter lastName")
	@Size(min=2,max=40,message="Last name should be mininum 2 char and max 25 char long")
	private String lastName;
	
	@NotNull(message = "Department is mandatory")
	@NotEmpty(message = "Please Enter department")
	private String department;
	
	@NotNull(message = "Designation is mandatory")
	@NotEmpty(message = "Please Enter designation")
	private String designation;
	
	@NotNull(message = "Email is mandatory")
	@NotEmpty(message = "Please Enter email")
	@Email(message = "Invalid Email")
	private String email;
	
	@NotNull(message = "Employee should have some salary")
	@NotEmpty(message = "Please Enter salary")
	private Double salary;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@NotEmpty(message = "Please add address to employee")
	private List<Address> addresses;
	

}
