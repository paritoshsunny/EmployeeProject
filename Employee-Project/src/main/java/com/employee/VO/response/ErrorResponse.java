package com.employee.VO.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
	
	private String timestamp;
	private String code;
	private String status;
	private String message;

}
