package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entities.Customer;


public class CustomerDaoImpl implements CustomerDao{
	
	private static final Map<String, Customer> customerMap = new HashMap<>();

	@Override
	public List<Customer> getAllCustomers() {

		return new ArrayList<Customer>(customerMap.values());
	}

	@Override
	public Customer checkCustomer(String phone) {
		if(customerMap.containsKey(phone)) {
			return customerMap.get(phone);
		}
		return null;
	}

	@Override
	public void addCustomer(Customer customer) {
		customerMap.put(customer.getPhone(), customer);
		
	}

}
