package com.cg.pizza.services;

import java.util.List;

import com.cg.pizza.beans.Customer;
import com.cg.pizza.beans.PizzaOrder;
import com.cg.pizza.exceptions.CustomerDetailsNotFoundException;
public interface PizzaServices {
	Customer acceptCustomerDetails(Customer customer);

	PizzaOrder acceptPizzaOrderDetails(PizzaOrder pizzaOrder);

	Customer getCustomerDetails(int customerId)throws CustomerDetailsNotFoundException;

	List<Customer> getAllCustomerDetails();
	boolean removeCustomerDetails(int customerId)throws CustomerDetailsNotFoundException;
}
