package utils;

import java.util.List;
import java.util.Scanner;

import entities.Customer;

public class CustomerUtils {
	public static final Scanner sc = new Scanner(System.in);

	private CustomerUtils() {
	}

	public static void changePin(Customer customer) {
		System.out.println("Nhập mã pin cũ");
		String oldPin = sc.nextLine();
		if (customer.getPin().equals(oldPin)) {
			System.out.println("Nhập mã pin mới");
			String newPin = sc.nextLine();
			customer.setPin(newPin);
			System.out.println("đổi mã pin thành công ");
		} else {
			System.out.println("Nhập sai mã pin cũ đổi mã thất bại");
		}
	}

	public static void withdraw(Customer customer) {
		double money;
		System.out.println("Nhập số tiền muốn rút chia hết cho 50000: ");
		money = Double.parseDouble(sc.nextLine());
		while (money > customer.getBalance() || money < 50000 || money % 50000 != 0) {
			System.out.println("Nhập sai mời nhập lại: ");
			money = Double.parseDouble(sc.nextLine());
		}
		customer.setBalance(customer.getBalance() - money);
		System.out.println("Rút tiền thành công");
	}

	public static void transfer(Customer customer, List<Customer> customers) {
		double money;
		System.out.println("Nhập id cần chuyển tiền: ");
		String id = sc.nextLine();
		Customer customer2 = checkAccount(customers, id);
		if (customer2 != null) {
			System.out.println("Nhập số tiền cần chuyển: ");
			money = Double.parseDouble(sc.nextLine());
			while (money > customer.getBalance()) {
				System.out.println("Số dư không đủ mời nhập lại:");
				money = Double.parseDouble(sc.nextLine());
			}
			customer.setBalance(customer.getBalance() - money);
			customer2.setBalance(customer.getBalance() + money);
			System.out.println("Chuyển tiền thành công");
		} else {
			System.out.println("Nhập id nhận tiền không đúng");
		}
	}

	public static Customer login(List<Customer> customers) {
		String id;
		String pin;
		int count = 0;
		while (true) {
			if (count == 3) {
				System.out.println("Nhập sai quá 3 lần");
				return null;
			}
			System.out.print("Nhập id: ");
			id = sc.nextLine();
			System.out.println("Nhập pin: ");
			pin = sc.nextLine();
			Customer customer = checkAccount(customers, id, pin);
			if (customer != null) {
				return customer;
			} else {
				System.out.println("id hoặc pin không đúng");
				count++;
			}

		}
	}

	private static Customer checkAccount(List<Customer> customers, String id, String pin) {
		return customers.stream().filter(s -> s.getId().equals(id) && s.getPin().equals(pin)).findAny().orElse(null);
	}

	private static Customer checkAccount(List<Customer> customers, String id) {
		return customers.stream().filter(s -> s.getId().equals(id)).findAny().orElse(null);
	}

}
