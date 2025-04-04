package com.valtech.training.assignment.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.assignment.entities.Customer;
import com.valtech.training.assignment.repo.CustomerRepo;
import com.valtech.training.assignment.vos.CustomerVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CustomerServiceImpl implements CustomerService {

	
	@Autowired
	private CustomerRepo customerRepo;
	
	
	
	@Override
	public CustomerVO createCustomer(CustomerVO customerVO) {
		

		return CustomerVO.from(customerRepo.save(customerVO.to()));		
	}
	
	
	@Override
	public CustomerVO getCustomerById(long id) {
		
		
		return CustomerVO.from(customerRepo.getReferenceById(id));
		
	}
	
	
	@Override
	public List<CustomerVO> getCustomers(){
		System.out.println("Inside Customer Services"+customerRepo.findAll());
		return customerRepo.findAll().stream().map(w->CustomerVO.from(w)).collect(Collectors.toList());
	}
	
}
