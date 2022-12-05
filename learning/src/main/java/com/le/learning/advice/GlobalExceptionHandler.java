package com.le.learning.advice;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.le.learning.exception.NotFoundException;
import com.le.learning.model.ExceptionResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public  @ResponseBody ExceptionResponse handleException(final Exception exception) {
		ExceptionResponse exceptionResponse =new ExceptionResponse();
		exceptionResponse.setErrorMessage(exception.getMessage());
		exceptionResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		exceptionResponse.setTimestamp(new Date().toString());
		return exceptionResponse;
	}
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ExceptionResponse handleException(final NotFoundException exception) {
		ExceptionResponse exceptionResponse =new ExceptionResponse();
		exceptionResponse.setErrorMessage(exception.getMessage());
		exceptionResponse.setStatus(HttpStatus.NOT_FOUND.toString());
		exceptionResponse.setTimestamp(new Date().toString());
		return exceptionResponse;
	}


}
