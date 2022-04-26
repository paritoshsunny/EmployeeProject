package com.employee.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long addId;

	@NotNull(message = "House number is mandatory")
	@NotEmpty(message = "Please Enter House number")
	private Integer houseNo;
	@NotEmpty(message = "Please Enter Address Line 1")
	@NotNull(message = "Address Line 1 is mandatory")
	private String addressLine1;
	private String addressline2;
	@NotEmpty(message = "Please Enter city")
	@NotNull(message = "city is mandatory")
	private String city;
	@NotEmpty(message = "Please Enter state")
	@NotNull(message = "state is mandatory")
	private String state;
	@NotEmpty(message = "Please Enter country")
	@NotNull(message = "country is mandatory")
	private String country;
	@NotEmpty(message = "Please Enter zipCode")
	@NotNull(message = "Zip Code is mandatory")
	private Integer zipCode;

}
