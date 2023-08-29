package com.cdac.Exception;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> resourceNotFoundExceptionHandler(NoSuchElementException exception){
		
		return new ResponseEntity<String>("Data not found",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<String> emptyResultDataAccessException(EmptyResultDataAccessException exception){
    	return new ResponseEntity<String>("No Company with this Id exist!!!",HttpStatus.NOT_ACCEPTABLE);
    }
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
    	Map<String,String> response = new HashMap<>();
    	exception.getBindingResult().getAllErrors().forEach((error)->{
    		String fieldName = ((FieldError)error).getField();
    		String message = error.getDefaultMessage();
    		response.put(fieldName, message);
    	});
    	
    	return new ResponseEntity<Map<String,String>>(response,HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<String> nullPointerException(NullPointerException exception){
		return new ResponseEntity<String>("No data found..!",HttpStatus.NOT_FOUND);
	}

}
