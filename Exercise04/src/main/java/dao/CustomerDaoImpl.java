package dao;

import java.util.ArrayList;
import java.util.List;

import entities.Customer;

public class CustomerDaoImpl implements CustomerDao {

	public List<Customer> getAllCustomer() {

		return mockdata();
	}
	
	private List<Customer> mockdata(){
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer("01","1234", "Khanh", "BIDV", 500000));
		customers.add(new Customer("02","0000", "Long", "ACB",1000000 ));
		customers.add(new Customer("03","4321", "Sang", "Đông Á", 1500000));
		
		return customers;
	}

}
