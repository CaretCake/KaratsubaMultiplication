import java.math.BigInteger;

public class KaratsubaMultiplier {

  public BigInteger getProductOf(String firstOp, String secondOp) {

    BigInteger firstOperand = new BigInteger(firstOp);
    BigInteger secondOperand = new BigInteger(secondOp);
    int numberOfDigits = Math.max(firstOp.length(), secondOp.length());
    //System.out.println("calculating: " + firstOp + " * " + secondOp);

    // check base case: if digit length <= 9
    if (firstOp.length() < 10 && secondOp.length() < 10) {
      // return converted operands * each other
      return firstOperand.multiply(secondOperand);
    } else { // else do Karatsuba
      // if length > 9, do with getProductOf
      BigInteger xHigh = getHighHalf(firstOperand);
      BigInteger xLow = getLowHalf(firstOperand);
      BigInteger yHigh = getHighHalf(secondOperand);
      BigInteger yLow = getLowHalf(secondOperand);
      /*System.out.println("xHigh: " + xHigh);
      System.out.println("xLow: " + xLow);
      System.out.println("yHigh: " + yHigh);
      System.out.println("yLow: " + yLow);*/
      // calculate P1 = xh*yh
      BigInteger productOne = this.getProductOf(xHigh.toString(), yHigh.toString());
      // calculate P2 = xl*yl
      BigInteger productTwo = this.getProductOf(xLow.toString(), yLow.toString());
      // calculate P3 = (xh+xl)(yh+yl)
      BigInteger productThree = this.getProductOf((xHigh.add(xLow)).toString(), (yHigh.add(yLow)).toString());
      /*System.out.println("P1: " + productOne);
      System.out.println("P2: " + productTwo);
      System.out.println("P3: " + productThree);*/
      //System.out.println("Sub: " + subtracted);

      //System.out.println("f1: " +Long.parseLong((Long.toString(productOne) + "00000000000")) +"\nf2: "+((subtracted) * Math.pow(10, (numberOfDigits / 2)))+"\nf3: "+productTwo);
      if (numberOfDigits % 2 != 0) {
        numberOfDigits++;
      }
      BigInteger nPower = new BigInteger("10");
      nPower = nPower.pow(numberOfDigits);
      BigInteger nHalfPower = new BigInteger("10");
      nHalfPower = nHalfPower.pow(numberOfDigits/2);

      BigInteger result = new BigInteger("0");
      result = result.add(productOne.multiply(nPower));
      BigInteger sub = productOne.add(productTwo);
      result = result.add((productThree.subtract(sub)).multiply(nHalfPower));
      result = result.add(productTwo);
      // return P1*10^n + (P3-P2-P1)10^n/2 + P2
      return result;
    }
  }

  private BigInteger getHighHalf(BigInteger bigInt) {
    String bigIntString = bigInt.toString();
    return new BigInteger(bigIntString.substring(0, bigIntString.length()/2));
  }

  private BigInteger getLowHalf(BigInteger bigInt) {
    String bigIntString = bigInt.toString();
    return new BigInteger(bigIntString.substring(bigIntString.length()/2));
  }
}
