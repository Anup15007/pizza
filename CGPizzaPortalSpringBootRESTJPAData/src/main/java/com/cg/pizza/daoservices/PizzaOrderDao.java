package com.cg.pizza.daoservices;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.pizza.beans.PizzaOrder;

public interface PizzaOrderDao extends JpaRepository<PizzaOrder, Integer> {

}
