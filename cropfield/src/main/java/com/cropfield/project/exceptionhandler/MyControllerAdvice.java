package com.cropfield.project.exceptionhandler;

import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cropfield.project.exceptions.EmptyInputException;
import com.cropfield.project.exceptions.EmptyListException;



@ControllerAdvice
public class MyControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleEmptyInputException(EmptyInputException emptyInput) {

		return new ResponseEntity<String>("Input fields are empty,please look into it from empty input",
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<String> handleNullPointerException(NullPointerException nullInput) {

		return new ResponseEntity<String>("Please check all the feilds are entered", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EmptyListException.class)
	public ResponseEntity<String> handleEmptyListException(EmptyListException emptyList) {

		return new ResponseEntity<String>("There is no data to display", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(IllegalStateException.class)
	public ResponseEntity<String> handleIllegalStateException(IllegalStateException illegalexception) {

		return new ResponseEntity<String>("Please enter valid input", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException nosuchelementexception) {

		return new ResponseEntity<String>("The required details not present in the database,please recheck",
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<String> handleMethodArgumentTypeMismatchException(
			MethodArgumentTypeMismatchException typemismatchexception) {

		return new ResponseEntity<String>("Please provide valid input,The requested input is incorrect",
				HttpStatus.BAD_REQUEST);
	}


	  
	  @Override 
	  protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException
	  ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	  
	  return new ResponseEntity<Object>
	  ("Requested method is not supported , please check the request method type" ,HttpStatus.NOT_FOUND); }
	 
}
