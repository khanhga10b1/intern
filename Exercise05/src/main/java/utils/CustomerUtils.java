package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import common.CustomerObject;
import entities.Customer;
import entities.Ticket;
import entities.Trip;
import service.CustomerService;
import service.CustomerServiceImpl;
import service.TicketService;
import service.TicketServiceImpl;
import service.TripService;
import service.TripServiceImpl;

public class CustomerUtils {
	public static final CustomerService customerService = new CustomerServiceImpl();
	public static final TripService tripService = new TripServiceImpl();
	public static final TicketService ticketService = new TicketServiceImpl();
	public static final Scanner sc = new Scanner(System.in);

	private CustomerUtils() {

	}

	public static void searchTicket() {

		while (true) {
			System.out.println("Nhập số điện thoại cần tìm.");
			String phone = inputPhone();

			List<Ticket> tickets = ticketService.getAllTickets().stream()
					.filter(s -> s.getCustomer().getPhone().equals(phone)).collect(Collectors.toList());

			tickets.forEach(System.out::println);
			System.out.println(1 + ". In hóa đơn.");
			System.out.println(2 + ". tiếp tục tìm kiếm.");
			System.out.println(3 + ". Quay lại.");

			switch (inputNumber()) {
			case 1:
				tickets.forEach(System.out::println);
				System.out.println("giảm 20% cho trẻ em và 15 % cho người lớn tuổi");
				System.out.println("Tổng: " + bill(tickets));
				return;
			case 2:
				break;

			default:
				return;
			}
		}
	}

	private static double bill(List<Ticket> tickets) {

		double sum = 0;
		for (Ticket ticket : tickets) {
			sum += ticket.getTrip().getPrice() * discount(ticket.getCustomerObject());
		}

		return sum;
	}

	private static double discount(CustomerObject ob) {
		return ob.equals(CustomerObject.CHILDEN) ? 0.8 : (ob.equals(CustomerObject.ELDER) ? 0.85 : 1);
	}

	public static void updateOrDeleteTrip() {
		while (true) {
			int index = 0;
			System.out.println("Chọn chuyến đi cần thay đổi.");
			List<Trip> trips = tripService.getAllTrips();
			for (int i = 0; i < trips.size(); i++) {
				System.out.println(i + 1 + ". " + trips.get(i));
			}
			System.out.println(trips.size() + 1 + ". Quay lại.");
			index = inputNumber();
			if (index == trips.size() + 1) {
				return;
			}
			System.out.println(trips.get(index - 1));
			System.out.println("1. Xóa chuyến đi.");
			System.out.println("2. Chỉnh sửa chuyến đi.");
			System.out.println("3. Hủy.");
			switch (inputNumber()) {
			case 1:
				tripService.deleteTrip(trips.get(index - 1));
				System.out.println("xóa thành công");
				break;
			case 2:
				System.out.println("Sửa tên chuyến đi:");
				trips.get(index - 1).setTripName(sc.nextLine());
				tripService.addTrip(trips.get(index - 1));
				
			default:
				break;
			}
		}
	}

	public static void addTrip() {
		System.out.print("nhập mã chuyến đi: ");
		String id = sc.nextLine();
		System.out.print("Nhập tên chuyến đi: ");
		String tripName = sc.nextLine();
		System.out.print("Nhập địa điểm đi: ");
		String startPlace = sc.nextLine();
		System.out.print("Nhập địa điểm đến: ");
		String endPlace = sc.nextLine();
		System.out.print("Nhập thời gian đi dd/MM/yyyy HH:mm: ");
		LocalDateTime startTime = LocalDateTime.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
		System.out.print("Nhập thời gian đến dd/MM/yyyy HH:mm: ");
		LocalDateTime endTime = LocalDateTime.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
		System.out.println("Nhập giá: ");
		Double price = Double.parseDouble(sc.nextLine());
		System.out.println("Nhập số lượng chỗ: ");
		Integer slot = inputNumber();
		tripService.addTrip(new Trip(id, tripName, startPlace, endPlace, startTime, endTime, price, slot));
		tripService.getAllTrips().forEach(System.out::println);
	}

	public static void deleteTicket() {
		while (true) {
			int index = 0;
			System.out.println("Chọn vé cần hủy.");
			List<Ticket> tickets = ticketService.getAllTickets();
			for (int i = 0; i < tickets.size(); i++) {
				System.out.println(i + 1 + ". " + tickets.get(i));
			}
			System.out.println(tickets.size() + 1 + ". Quay lại");
			index = inputNumber();
			if (index == tickets.size() + 1) {
				return;
			}
			ticketService.deleteTicket(tickets.get(index - 1));
			System.out.println("Hủy vé thành công.");
		}
	}

	public static void bookTicket() {
		int index = 0;
		int count = 0;
		System.out.println("Chọn chuyến đi cần đặt vé.");
		List<Trip> trips = tripService.getAllTrips();
		for (int i = 0; i < trips.size(); i++) {
			System.out.println(i + 1 + ". " + trips.get(i));
		}
		System.out.println(trips.size() + 1 + ". Quay lại.");
		index = inputNumber();
		if (index == trips.size() + 1) {
			return;
		}
		System.out.print("Nhập SĐT: ");
		String phone = sc.nextLine();
		Customer customer = customerService.checkCustomer(phone);
		if (customer == null) {
			customer = new Customer();
			System.out.print("Nhập tên: ");
			customer.setName(sc.nextLine());
			customer.setPhone(phone);
		}
		System.out.print("Chọn số vé cần đặt: ");
		count = inputNumber();
		for (int i = 0; i < count; i++) {
			Ticket ticket = new Ticket();
			ticket.setCustomer(customer);
			ticket.setTrip(trips.get(index - 1));
			System.out.print("Nhập mã vé: ");
			ticket.setId(sc.nextLine());
			System.out.println("chọn:");
			System.out.println("1.trẻ em");
			System.out.println("2.Người lớn");
			System.out.println("3.Người già");
			ticket.setCustomerObject(CustomerObject.getCustomer(inputNumber()));
			ticketService.addTicket(ticket);
		}

	}

	public static int inputNumber() {
		String numberString = sc.nextLine();
		while (true) {
			if (numberString.matches("[0-9]+")) {
				break;
			} else {
				numberString = sc.nextLine();
			}
		}
		return Integer.parseInt(numberString);
	}

	public static String inputPhone() {
		String numberString = sc.nextLine();
		while (true) {
			if (numberString.matches("[0-9]{2,15}")) {
				break;
			} else {
				System.out.println("Nhập sai định dạng nhập lại");
				numberString = sc.nextLine();
			}
		}
		return numberString;
	}
}
