package view;

import static utils.CustomerUtils.*;

public class TicketDemo {

	public static void main(String[] args) {
		menu();

	}

	private static void menu() {
		int choose = 0;
		while (choose < 6) {
			System.out.println("===========||=============||===");
			System.out.println("1. Hiển thị danh sách và đặt chuyến đi.");
			System.out.println("2. Hiển thị danh sách và hủy vé đã đặt.");
			System.out.println("3. Tìm vé theo khách hàng và in hóa đơn.");
			System.out.println("4. Thêm mới chuyến đi.");
			System.out.println("5. Sửa hoặc xóa chuyến đi");
			System.out.println("6. Thoát");
			System.out.println("===========||=============||===");
			choose = inputNumber();
			switch (choose) {
			case 1:
				bookTicket();
				break;
			case 2:
				deleteTicket();
				break;
			case 3:
				searchTicket();
				break;
			case 4:
				addTrip();
				break;
			case 5:
				deleteTicket();
				break;
			default:
				return;

			}

		}
	}
}