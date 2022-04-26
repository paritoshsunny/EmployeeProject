package com.employee.VO.response;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommonEmployeeResponse {
	
	private List<EmployeeVO> employees;
	private Integer statusCode;
	private String message;
	private LocalDateTime timestamp;

}
