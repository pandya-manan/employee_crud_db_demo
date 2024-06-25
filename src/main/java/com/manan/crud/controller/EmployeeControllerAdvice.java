package com.manan.crud.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.manan.crud.exception.EmployeeErrorResponse;
import com.manan.crud.exception.EmployeeException;


@RestControllerAdvice
public class EmployeeControllerAdvice {
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeException e)
	{
		//create a student error response
		EmployeeErrorResponse error=new EmployeeErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		LocalDateTime now = LocalDateTime.now();  
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
		String formatDateTime = now.format(format);  
		error.setTimeStamp(formatDateTime);
		//return response entity
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse>handleAllException(Exception e)
	{
		EmployeeErrorResponse error=new com.manan.crud.exception.EmployeeErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(e.getMessage());
		LocalDateTime now = LocalDateTime.now();  
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
		String formatDateTime = now.format(format);  
		error.setTimeStamp(formatDateTime);
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}

}
