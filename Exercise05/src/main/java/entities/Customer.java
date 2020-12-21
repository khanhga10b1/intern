package entities;

import java.util.Objects;


public class Customer {
	private String phone;
	private String name;

	public Customer() {
	}

	public Customer(String phone, String name) {
		this.phone = phone;
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Customer)) {
			return false;
		}

		Customer that = (Customer) o;
		return Objects.equals(getName(), that.getName()) && Objects.equals(getPhone(), that.getPhone());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(phone,name);
	}

	@Override
	public String toString() {
		return "Khách Hàng: "+name+" SĐT: "+phone;
	}

}
