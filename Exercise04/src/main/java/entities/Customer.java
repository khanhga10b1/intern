package entities;

public class Customer {
	private String id;
	private String pin;
	private String fullname;
	private String bank;
	private double balance;
	public Customer() {
	}

	public Customer(String id,String pin, String fullname, String bank, double balance) {
		this.id = id;
		this.pin=pin;
		this.fullname = fullname;
		this.bank = bank;
		this.balance = balance;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	
	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "Id: "+id+", Tên: "+fullname+", Ngân hàng: "+bank+", Số dư: "+balance+", Mã pin: "+pin;
	}

	

}