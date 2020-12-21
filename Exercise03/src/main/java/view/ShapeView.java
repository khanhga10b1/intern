package view;

public class ShapeView {
	public static void main(String[] args) {

		draw1Z(7);
		System.out.println("================");
		draw2Z(7);
		System.out.println("================");
		draw3(7);
		System.out.println("================");
		draw4(11);
		System.out.println("================");
		draw7(7);
		System.out.println("================");
		draw5(5);
		System.out.println("================");
		draw6(5);

	}
	
	private static void draw6(int line) {
		for(int i=0;i<line;i++) {
			for(int j=0;j<line -i-1;j++) {
				System.out.print(" ");
			}
			for(int j=0;j<i+1;j++) {
				System.out.print(j+1);
			}
			System.out.println();
		}
	}
	
	private static void draw5(int line) {
		for(int i=0;i<line;i++) {
			for(int j=0;j<i;j++) {
				System.out.print(" ");
			}
			for(int j=0;j<line-i;j++) {
				System.out.print(j+1);
			}
			System.out.println();
		}
	}
	
	private static void draw7(int line) {
		for (int i = 0; i < line; i++) {
			for (int j = 0; j < line; j++) {
				if (i == 0 || i == line - 1) {
					System.out.print("*");
				} else if (j == i || j == line - i - 1 || j == 0 || j ==line-1) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	

	private static void draw4(int line) {
		int temp =0;
		for (int i = 0; i < line; i++) {
			
			if (i < line/2 ) {
				for (int j = 0; j < line/2 - i ; j++) {
					System.out.print(" ");
				}
				for (int j = 0; j < 2 * i + 1; j++) {
					System.out.print("*");
				}
				System.out.println();
			} else {
				for (int j = 0; j < temp ; j++) {
					System.out.print(" ");
				}
				for (int j = 0; j < 2 * (line/2 -temp) + 1; j++) {
					System.out.print("*");
				}
				temp ++;
				System.out.println();
			}
		}
	}

	private static void draw3(int line) {
		for (int i = 0; i < line; i++) {
			for (int j = 0; j < line; j++) {
				if (i == 0 || i == line - 1) {
					System.out.print("*");
				} else if (j == i || j == line - i - 1) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	private static void draw2Z(int line) {
		for (int i = 0; i < line; i++) {
			for (int j = 0; j < line; j++) {
				if (i == 0 || i == line - 1) {
					System.out.print("*");
				} else if (j == line - i - 1) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	private static void draw1Z(int line) {
		for (int i = 0; i < line; i++) {
			for (int j = 0; j < line; j++) {
				if (i == 0 || i == line - 1) {
					System.out.print("*");
				} else if (j == i) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

}
