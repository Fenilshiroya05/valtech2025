package com.valtech.training.assignment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.assignment.entities.Customer;


@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
