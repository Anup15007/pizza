package com.cg.pizza.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class PizzaOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderId;
	private String pizzaType;
	private String pizzaName;
	@JsonManagedReference
	@ManyToOne
	Customer customer;
	public PizzaOrder() {}
	public PizzaOrder(String pizzaType, String pizzaName, Customer customer) {
		super();
		this.pizzaType = pizzaType;
		this.pizzaName = pizzaName;
		this.customer = customer;
	}
	public PizzaOrder(int orderId, String pizzaType, String pizzaName, Customer customer) {
		super();
		this.orderId = orderId;
		this.pizzaType = pizzaType;
		this.pizzaName = pizzaName;
		this.customer = customer;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + orderId;
		result = prime * result + ((pizzaName == null) ? 0 : pizzaName.hashCode());
		result = prime * result + ((pizzaType == null) ? 0 : pizzaType.hashCode());
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
		PizzaOrder other = (PizzaOrder) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (orderId != other.orderId)
			return false;
		if (pizzaName == null) {
			if (other.pizzaName != null)
				return false;
		} else if (!pizzaName.equals(other.pizzaName))
			return false;
		if (pizzaType == null) {
			if (other.pizzaType != null)
				return false;
		} else if (!pizzaType.equals(other.pizzaType))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PizzaOrder [orderId=" + orderId + ", pizzaType=" + pizzaType + ", pizzaName=" + pizzaName
				+ ", customer=" + customer + "]";
	}

	
}
