package entities;

import java.util.Objects;

import common.CustomerObject;

public class Ticket {
	private String id;
	private Trip trip;
	private Customer customer;
	private CustomerObject customerObject;

	public Ticket() {
	}

	public Ticket(String id,Trip trip, Customer customer, CustomerObject customerObject) {
		this.id = id;
		this.trip = trip;
		this.customerObject = customerObject;
		this.customer = customer;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public CustomerObject getCustomerObject() {
		return customerObject;
	}

	public void setCustomerObject(CustomerObject customerObject) {
		this.customerObject = customerObject;
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Ticket)) {
			return false;
		}
		Ticket that = (Ticket) o;
		return Objects.equals(that.getTrip(), getTrip()) && Objects.equals(that.getCustomer(), getCustomer())
				&& Objects.equals(that.getCustomerObject(), getCustomerObject())
				&& Objects.equals(that.getId(), getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(trip, customer, customerObject);
	}

	@Override
	public String toString() {
		return customer + " đặt " + trip;
	}

}
