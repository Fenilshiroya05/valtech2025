package services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import classes.Customer;
import dao.CustomerDAO;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerDAO customerDAO;
	
	
	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}
	@Override
	@Transactional
	public void save(Customer c) {
		customerDAO.save(c);
	}

	@Override
	public void update(Customer c) {
		
		customerDAO.update(c);
		
	}

	@Override
	public void delete(int id) {
		customerDAO.delete(id);
		
	}

	@Override
	public Customer get(int id) {
		
		return customerDAO.get(id);
	}

	@Override
	public List<Customer> getAll() {
		
		return customerDAO.getAll();
	}

}