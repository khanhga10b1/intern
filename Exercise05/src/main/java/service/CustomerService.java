package service;

import java.util.List;

import entities.Customer;

public interface CustomerService {
	List<Customer> getAllCustomers();
	Customer checkCustomer(String phone);
	void addCustomer(Customer customer);
}
