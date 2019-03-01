import java.util.Scanner;
import java.text.DecimalFormat;

public class MultiplyLongIntegers {
	public static void main(String[] args) {

		KaratsubaMultiplier karatMultiplier = new KaratsubaMultiplier();
		DecimalFormat decimalFormat = new DecimalFormat("#,###");

		if(args.length == 2) {
			System.out.println(args[0] + " * " + args[1] + " = " + decimalFormat.format(karatMultiplier.getProductOf(args[0], args[1])));
		} else {

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
