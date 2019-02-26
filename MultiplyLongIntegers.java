public class MultiplyLongIntegers {
	public static void main(String[] args) {
		// max long length: 9 digits
		KaratsubaMultiplier karatMultiplier = new KaratsubaMultiplier();

		try {
			System.out.println(args[0] + " * " + args[1] + " = " + karatMultiplier.getProductOf(args[0], args[1]));
		} catch (longIntConversionException err) {
			System.out.println(err);
			System.exit(0);
		}
	}
}
