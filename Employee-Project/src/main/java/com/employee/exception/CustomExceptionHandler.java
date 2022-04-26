package com.employee.exception;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.employee.VO.response.ErrorResponse;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{
	
	
	@Override
	@ExceptionHandler(ConstraintViolationException.class)
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse();

		ex.getBindingResult().getAllErrors().forEach((error) -> {
			errorResponse.setCode("400");
			errorResponse.setMessage(error.getDefaultMessage());
			errorResponse.setStatus("BAD REQUEST");
			errorResponse.setTimestamp(LocalDateTime.now().toString());
		});
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException ex) {
		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setCode("404");
		errorResponse.setMessage(ex.getLocalizedMessage());
		errorResponse.setStatus("Not Found");
		errorResponse.setTimestamp(LocalDateTime.now().toString());
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

}
