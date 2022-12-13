package com.example.demo.interview.errorHandling;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationControllerAdvice extends ResponseEntityExceptionHandler{

	// with time constraint just have single implementtion for error handling , ideally it is expected multiple business specific exceptions
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception 
	{
		ExceptionDetails exDetails = new ExceptionDetails("GENERIC_ERROR",ex.getMessage(), LocalDateTime.now() );
		return new ResponseEntity<Object>(exDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
