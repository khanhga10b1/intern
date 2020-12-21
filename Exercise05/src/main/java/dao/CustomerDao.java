package dao;

import java.util.List;

import entities.Customer;

public interface CustomerDao {
	List<Customer> getAllCustomers();
	Customer checkCustomer(String phone);
	void addCustomer(Customer customer);
}
