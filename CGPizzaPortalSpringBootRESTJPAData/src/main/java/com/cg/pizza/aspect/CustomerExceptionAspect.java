package com.cg.pizza.aspect;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.pizza.exceptions.CustomerDetailsNotFoundException;
import com.cg.pizza.response.PizzaResponse;

@ControllerAdvice
public class CustomerExceptionAspect {
	@ExceptionHandler(CustomerDetailsNotFoundException.class)
	public ResponseEntity<PizzaResponse>handelAssociaateDetailsNotFoundException(Exception e){
		PizzaResponse response=new PizzaResponse(e.getMessage(),HttpStatus.EXPECTATION_FAILED.value());
		return new ResponseEntity<>(response,HttpStatus.EXPECTATION_FAILED);
	}
}
