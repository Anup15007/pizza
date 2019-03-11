package com.cg.pizza.daoservices;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.pizza.beans.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer>{

}
