package com.valtech.training.assignment.services;

import java.util.List;

import com.valtech.training.assignment.vos.CustomerVO;

public interface CustomerService {

	CustomerVO createCustomer(CustomerVO customerVO);

	CustomerVO getCustomerById(long id);

	List<CustomerVO> getCustomers();

}