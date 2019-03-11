package com.cg.pizza.beans;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int customerId;
	private String firstName;
	private String lastName;
	private String address;
	@JsonBackReference
	@OneToMany(mappedBy="customer")
	@MapKey
	private Map<Integer,PizzaOrder> customerPizzas;
	public Customer() {}
	public Customer(int customerId, String firstName, String lastName, String address,
			Map<Integer, PizzaOrder> customerPizzas) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.customerPizzas = customerPizzas;
	}
	public Customer(String firstName, String lastName, String address, Map<Integer, PizzaOrder> customerPizzas) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.customerPizzas = customerPizzas;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Map<Integer, PizzaOrder> getCustomerPizzas() {
		return customerPizzas;
	}
	public void setCustomerPizzas(Map<Integer, PizzaOrder> customerPizzas) {
		this.customerPizzas = customerPizzas;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + customerId;
		result = prime * result + ((customerPizzas == null) ? 0 : customerPizzas.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (customerId != other.customerId)
			return false;
		if (customerPizzas == null) {
			if (other.customerPizzas != null)
				return false;
		} else if (!customerPizzas.equals(other.customerPizzas))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + ", customerPizzas=" + customerPizzas + "]";
	}

	
	
}
