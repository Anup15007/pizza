package com.cg.pizza.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.cg.pizza.beans.Customer;
import com.cg.pizza.beans.PizzaOrder;
import com.cg.pizza.daoservices.CustomerDao;
import com.cg.pizza.daoservices.PizzaOrderDao;
import com.cg.pizza.exceptions.CustomerDetailsNotFoundException;

@Component("pizzaServices")
public class PizzaServicesImpl implements PizzaServices {
	@Autowired
	private CustomerDao customerDao;
	private PizzaOrderDao pizzaOrderDao;
	@Override
	public Customer acceptCustomerDetails(Customer customer) {
		customer = customerDao.save(customer);
		return customer;
	}

	@Override
	public PizzaOrder acceptPizzaOrderDetails(PizzaOrder pizzaOrder) {
		pizzaOrder=pizzaOrderDao.save(pizzaOrder);
		return pizzaOrder;
	}

	@Override
	public Customer getCustomerDetails(int customerId) throws CustomerDetailsNotFoundException {
		return customerDao.findById(customerId).orElseThrow(()->new CustomerDetailsNotFoundException("Customer Details Not Found for customerId"+customerId));
	}


	@Override
	public boolean removeCustomerDetails(int customerId) throws CustomerDetailsNotFoundException {
		customerDao.delete(getCustomerDetails(customerId));
		return true;
	}

	@Override
	public List<Customer> getAllCustomerDetails() {
		return customerDao.findAll();
	}



}
