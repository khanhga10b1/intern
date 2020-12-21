package service;

import java.util.List;

import dao.CustomerDao;
import dao.CustomerDaoImpl;
import entities.Customer;

public class CustomerServiceImpl implements CustomerService {
	private final CustomerDao dao;
	public CustomerServiceImpl() {
		dao = new CustomerDaoImpl();
	}

	@Override
	public List<Customer> getAllCustomer() {
		return dao.getAllCustomer();
	}

}
