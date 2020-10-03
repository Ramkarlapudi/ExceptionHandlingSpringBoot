package com.ramkarlapudi.exceptionhandling.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedExceptions extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserExceptions.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "User Not Found")
	public final ResponseEntity<Object> handeluserExcep(UserExceptions ex, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(true));

		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(UploadProfileException.class)
	public final ResponseEntity<Object> handeluserExcep(UploadProfileException ex, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(true));

		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);

	}
}
