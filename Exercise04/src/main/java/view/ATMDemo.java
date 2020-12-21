package view;

import java.util.List;
import static utils.CustomerUtils.*;

import entities.Customer;
import service.CustomerService;
import service.CustomerServiceImpl;

public class ATMDemo {
	private static final CustomerService service = new CustomerServiceImpl();
	public static void main(String[] args) {
		List<Customer> customers =service.getAllCustomer();
		menu(customers);
		//id =01,pin =1234
		//id =02,pin =0000
		
	}
	private static void menu(List<Customer> customers) {
		Customer customer= login(customers);
		if(customer !=null) {
			while(true) {
				System.out.println("=========MENU=========");
				System.out.println("1.Xem thông tin");
				System.out.println("2.Rút tiền");
				System.out.println("3.Chuyển tiền");
				System.out.println("4.Đổi mã pin");
				System.out.println("5.hủy");
				int choose =inputNumber();
				switch (choose) {
				case 1:
					System.out.println(customer);
					break;
				case 2:
					withdraw(customer);
					break;			
				case 3:
					transfer(customer, customers);;
					break;
				case 4:
					changePin(customer);;
					break;
				default:
					return;

				}
			}
		}
		
	}
	private static int inputNumber() {
		int number = 0;
		String regex = "[0-9]+";
		while (true) {
			String numberString = sc.nextLine();
			if (!numberString.endsWith(".") && numberString.matches(regex)) {

				try {
					number = Integer.parseInt(numberString);
					break;
				} catch (NumberFormatException e) {
					System.out.println("sai định dạng nhập lại");
				}
			}
		}
		return number;
	}

}
