package view;

import java.util.Scanner;

public class CalculatorView {
	private static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.print("Nhập số thứ nhất: ");
		float firstNumber = inputNumber();
		System.out.print("Nhập số thứ hai: ");
		float secondNumber = inputNumber();

		System.out.println("Chọn phép toán: + - * /");
		String operator = inputOperator();
		System.out.println("Kết quả: " + calculate(firstNumber, secondNumber, operator));

	}

	private static float inputNumber() {
		float number = 0;
		String regex = "[-]?[0-9]+[.]?[0-9]*";
		while (true) {
			String numberString = sc.nextLine();
			if (!numberString.endsWith(".") && numberString.matches(regex)) {
				//không cần try catch lắm mà cứ làm cho chắc
				try {
					number = Float.parseFloat(numberString);
					break;
				} catch (NumberFormatException e) {
					System.out.println("sai định dạng nhập lại");
				}
			}else {
				System.out.println("sai định dạng nhập lại");
			}
		}
		return number;
	}

	private static String inputOperator() {
		String operators = "+-*/";
		String operator = "";
		while (true) {
			operator = sc.nextLine();
			if (operators.contains(operator)) {
				break;
			}else {
				System.out.println("toán tử không phù hợp chọn lại: ");
			}
		}
		return operator;
	}

	private static float calculate(float firstNumber, float secondNumber, String operator) throws ArithmeticException {
		switch (operator) {
		case "+":
			return firstNumber + secondNumber;
		case "-":
			return firstNumber - secondNumber;
		case "*":
			return firstNumber * secondNumber;
		case "/":
			if(secondNumber ==0) {
				throw new ArithmeticException("khi chia hệ số thứ 2 phải khác 0");
			}else {
				return firstNumber/secondNumber;
			}

		default:
			return Float.MIN_VALUE;
		}
	}
}
