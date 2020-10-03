package com.ramkarlapudi.exceptionhandling.exceptions;

import java.util.Date;

public class ExceptionResponse extends RuntimeException {

	
	public Date date ;
	public String message;
	public String details;
	
	
	
	
	public ExceptionResponse(Date date, String message, String details) {
		super();
		this.date = date;
		this.message = message;
		this.details = details;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	
}
