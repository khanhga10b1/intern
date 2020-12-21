package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import common.Number;
import common.Unit;

public class NumberView {
	private static final Number[] numbers = Number.values();
	private static final Unit[] units = Unit.values();
	private static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Nhập vào số: ");
		String number = sc.nextLine();
		String a = numberToWords(number);
		System.out.println(a);
//		System.out.println(splitNumber("1000000000", 9));

	}

	private static String numberToWords(String number) {
		String result = "";
		if (!number.matches("[0-9]+")) {
			return "Không phải số";
		}
		if(Integer.parseInt(number)==0) {
			return Number.KHONG.getName();
		}
		List<String> loops = splitNumber(number, 9);
		for (int j = 0; j < loops.size(); j++) {
			List<String> numbers = splitNumber(loops.get(j), 3);

			for (int i = 0; i < numbers.size(); i++) {
				if (units[numbers.size() - 1 - i] != Unit.TRAM) {
					if (numberToThreeWords(numbers.get(i)).isEmpty()) {
						continue;
					}
					result += numberToThreeWords(numbers.get(i)) + " " + units[numbers.size() - 1 - i].getName() + " ";
				} else {
					result += numberToThreeWords(numbers.get(i));
				}

			}
			if (loops.size() > 1 && j != loops.size() - 1) {
				result += " " + Unit.TY.getName() + " ";
			}
		}

		return result;
	}

	private static String numberToThreeWords(String number) {
		String result = "";
		if (!number.matches("[0-9]+")) {
			return "Không phải số";
		}

		int num = Integer.parseInt(number);

		if (num == 0) {
			return result;
		}
		if (number.length() == 3) {
			int hundred = Integer.parseInt(number.substring(0, 1));
			int ten = Integer.parseInt(number.substring(1, 2));
			int unit = Integer.parseInt(number.substring(2, 3));

			result = numbers[hundred].getName() + " " + Unit.TRAM.getName();
			switch (ten) {
			case 1:
				result += " " + Unit.MUOI.getName();
				break;
			case 0:
				if (unit != 0) {
					result += " " + Unit.LE.getName();
				}
				break;
			default:
				result += " " + numbers[ten].getName() + " " + Unit.MUOIS.getName();
				break;
			}

			switch (unit) {
			case 0:
				break;
			case 1:
				if (ten != 1 && ten != 0) {
					result += " " + Unit.MOTS.getName();
				} else {
					result += " " + numbers[unit].getName();
				}
				break;
			case 5:
				result += " " + Unit.LAM.getName();
				break;
			default:
				result += " " + numbers[unit].getName();
				break;
			}
		} else if (number.length() == 2) {
			int ten = Integer.parseInt(number.substring(0, 1));
			int unit = Integer.parseInt(number.substring(1, 2));

			switch (ten) {
			case 1:
				result += Unit.MUOI.getName();
				break;
			case 0:
				if (unit != 0) {
					result += Unit.LE.getName();
				}
				break;
			default:
				result += numbers[ten].getName() + " " + Unit.MUOIS.getName();
				break;
			}

			switch (unit) {
			case 0:
				break;
			case 1:
				if (ten != 1 && ten != 0) {
					result += " " + Unit.MOTS.getName();
				} else {
					result += " " + numbers[unit].getName();
				}
				break;
			case 5:
				result += " " + Unit.LAM.getName();
				break;
			default:
				result += " " + numbers[unit].getName();
				break;
			}
		} else {
			int unit = Integer.parseInt(number.substring(0, 1));
			result += numbers[unit].getName();
		}
		return result;
	}

	private static List<String> splitNumber(String number, int length) {
		List<String> threeNumbers = new ArrayList<>();

		int first = number.length() % length;
		if (first != 0) {
			threeNumbers.add(number.substring(0, first));
		}

		for (int i = 0; i < number.length() / length; i++) {
			threeNumbers.add(number.substring(first + i * length, first + length + i * length));
		}

		return threeNumbers;
	}
}
