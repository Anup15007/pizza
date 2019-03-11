package com.cg.pizza.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.cg.pizza.beans.Customer;
import com.cg.pizza.exceptions.CustomerDetailsNotFoundException;
import com.cg.pizza.services.PizzaServices;



@Controller
public class PizzaOrderServicesController {
	@Autowired
	PizzaServices pizzaServices;
	@RequestMapping(value= {"/sayHello"},method=RequestMethod.GET)
	public ResponseEntity<String>sayHello(){
		return new ResponseEntity<String>("Hello world to all from RESTImpl",HttpStatus.OK);
	}
	@RequestMapping(value= {"/acceptCustomerDetails"},method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<String>acceptMovieDetails(@ModelAttribute Customer Customer){
		Customer=pizzaServices.acceptCustomerDetails(Customer);
		return new ResponseEntity<>("Customer details successfully addded CustomerId:-"+Customer.getCustomerId(),HttpStatus.OK);
	}
	@RequestMapping(value= {"/getCustomerDetails"},method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE,
			headers="Accept=application/json")
	public ResponseEntity<Customer>getCustomerDetailsRequestParam(@RequestParam int customerId)throws CustomerDetailsNotFoundException{
		Customer Customer=pizzaServices.getCustomerDetails(customerId);
		return new ResponseEntity<Customer>(Customer,HttpStatus.OK);

	}
}