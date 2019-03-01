import java.math.BigInteger;

public class KaratsubaMultiplier {

  /* Returns a BigInteger containing the value of the product of firstOp and secondOp.
	 *
 	 * @param firstOp the integer value for the first operand in form of a string
	 * @param secondOp the integer value for the second operand in form of a string
 	 * @return a BigInteger with the value of the product of firstOp and secondOp
 	 */
  public BigInteger getProductOf(String firstOp, String secondOp) {

    BigInteger firstOperand = new BigInteger(firstOp);
    BigInteger secondOperand = new BigInteger(secondOp);
    int numberOfDigits = Math.max(firstOp.length(), secondOp.length());

    if (firstOp.length() < 10 && secondOp.length() < 10) {
      return firstOperand.multiply(secondOperand);
    } else {
      BigInteger xHigh = getHighHalf(firstOperand, numberOfDigits);
      BigInteger xLow = getLowHalf(firstOperand, numberOfDigits);
      BigInteger yHigh = getHighHalf(secondOperand, numberOfDigits);
      BigInteger yLow = getLowHalf(secondOperand, numberOfDigits);
      // calculate P1 = xh*yh
      BigInteger productOne = this.getProductOf(xHigh.toString(), yHigh.toString());
      // calculate P2 = xl*yl
      BigInteger productTwo = this.getProductOf(xLow.toString(), yLow.toString());
      // calculate P3 = (xh+xl)(yh+yl)
      BigInteger productThree = this.getProductOf((xHigh.add(xLow)).toString(), (yHigh.add(yLow)).toString());

      if (numberOfDigits % 2 != 0) {
        numberOfDigits++;
      }
      BigInteger nPower = new BigInteger("10").pow(numberOfDigits);
      BigInteger nHalfPower = new BigInteger("10").pow(numberOfDigits/2);

      BigInteger result = new BigInteger("0");
      // add to result P1 * 10^n
      result = result.add(productOne.multiply(nPower));
      BigInteger sub = productOne.add(productTwo);
      // add to result P3 - (P2 + P1) * 10^n/2
      result = result.add((productThree.subtract(sub)).multiply(nHalfPower));
      // add to result P2
      result = result.add(productTwo);
      // return P1 * 10^n + (P3-P2-P1) * 10^n/2 + P2
      return result;
    }
  }

  /* Returns a BigInteger containing the value of the high half of the given BigInteger
   * by converting it to a String, prepending '0's to it as needed until it matches length
   * of the largest operand to account for uneven length operands, splitting on halfway/close
   * to halfway point, and returning it as a BigInteger.
   *
   * @param bigInt a BigInteger containing the value to split
   * @param numberOfDigits number of digits in the larger of the two operands
   * @return a BigInteger containing the value of the high half of bigInt
   */
  private BigInteger getHighHalf(BigInteger bigInt, int numberOfDigits) {
    String bigIntString = bigInt.toString();
    if (bigIntString.length() < numberOfDigits) {
      StringBuilder sBuilder = new StringBuilder();
      for (int i = 0; i < numberOfDigits; i++) {
        sBuilder.append("0");
      }
      bigIntString = sBuilder.append(bigIntString).toString();
    }
    return new BigInteger(bigIntString.substring(0, bigIntString.length()/2));
  }

  /* Returns a BigInteger containing the value of the low half of the given BigInteger
   * by converting it to a String, prepending '0's to it as needed until it matches length
   * of the largest operand to account for uneven length operands, splitting on halfway/close
   * to halfway point, and returning it as a BigInteger.
   *
   * @param bigInt a BigInteger containing the value to split
   * @param numberOfDigits number of digits in the larger of the two operands
   * @return a BigInteger containing the value of the low half of bigInt
   */
  private BigInteger getLowHalf(BigInteger bigInt, int numberOfDigits) {
    String bigIntString = bigInt.toString();
    if (bigIntString.length() < numberOfDigits) {
      StringBuilder sBuilder = new StringBuilder();
      for (int i = 0; i < numberOfDigits; i++) {
        sBuilder.append("0");
      }
      bigIntString = sBuilder.append(bigIntString).toString();
    }
    return new BigInteger(bigIntString.substring(bigIntString.length()/2));
  }
}
