package com.valtech.training.assignment.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.assignment.entities.Orders;


@Repository
public interface OrderRepo extends JpaRepository<Orders, Long> {

	public List<Orders> getOrdersByCustomerId(long id);
	
	
}
