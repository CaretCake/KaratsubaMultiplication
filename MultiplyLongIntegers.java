import java.util.Scanner;
import java.text.DecimalFormat;

public class MultiplyLongIntegers {
	public static void main(String[] args) {

		KaratsubaMultiplier karatMultiplier = new KaratsubaMultiplier();
		DecimalFormat decimalFormat = new DecimalFormat("#,###");

		if(args.length == 2) {
			System.out.println(args[0] + " * " + args[1] + " = " + decimalFormat.format(karatMultiplier.getProductOf(args[0], args[1])));
		} else {

			System.out.println("Hardcoded test cases:");
			System.out.println("Testing 0 * 0 = 0");
			System.out.println(decimalFormat.format(karatMultiplier.getProductOf("0", "0")));
			System.out.println("Testing 10111213 * 12101110 = 122,356,900,746,430");
			System.out.println(decimalFormat.format(karatMultiplier.getProductOf("10111213", "12101110")));
			System.out.println("Testing 1234567890123845 * 1239849320859221 = 1,530,678,160,124,650,596,155,500,224,745");
			System.out.println(decimalFormat.format(karatMultiplier.getProductOf("1234567890123845", "1239849320859221")));
			System.out.println("Testing 999999999999 * 999999999999 = 999,999,999,998,000,000,000,001");
			System.out.println(decimalFormat.format(karatMultiplier.getProductOf("999999999999", "999999999999")));

			System.out.println("Enter two numbers to multiply, or enter 'EXIT' to quit the program.	");
			Scanner scan = new Scanner(System.in);
			while (true) {
				System.out.printf("1st operand: ");
				String operandOne = scan.next();
				if (operandOne.equals("EXIT")) {
					break;
				}
				System.out.printf("2nd operand: ");
				String operandTwo = scan.next();
				if (operandTwo.equals("EXIT")) {
					break;
				}
				System.out.println("");
				System.out.println(operandOne + " * " + operandTwo + " = " + decimalFormat.format(karatMultiplier.getProductOf(operandOne, operandTwo)));
				System.out.println("\n");
			}
			System.out.println("Program exiting.");
			System.exit(0);
		}

	}
}
