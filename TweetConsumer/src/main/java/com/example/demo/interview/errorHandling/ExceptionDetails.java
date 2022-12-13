package com.example.demo.interview.errorHandling;

import java.time.LocalDateTime;

public class ExceptionDetails {
	
	private String error_code;
	private String errorMessage;
	private LocalDateTime time;
	
	public ExceptionDetails() {}
	public ExceptionDetails(String error_code, String errorMessage, LocalDateTime time) {
		super();
		this.error_code = error_code;
		this.errorMessage = errorMessage;
		this.time = time;
	}
	public String getError_code() {
		return error_code;
	}
	public void setError_code(String error_code) {
		this.error_code = error_code;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "ExceptionDetails [error_code=" + error_code + ", errorMessage=" + errorMessage + ", time=" + time + "]";
	}
	
	

}
