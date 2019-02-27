public class KaratsubaMultiplier {

  public long getProductOf(String firstOp, String secondOp) throws longIntConversionException {

    LongInt firstOperand = new LongInt(firstOp);
    LongInt secondOperand = new LongInt(secondOp);
    int numberOfDigits = Math.max(firstOp.length(), secondOp.length());
    System.out.println("calculating: " + firstOp + " * " + secondOp);

    // check base case: if digit length <= 9
    if (firstOperand.isValidLong() && secondOperand.isValidLong()) {
      // return converted operands * each other
      return firstOperand.getLongConversion() * secondOperand.getLongConversion();
    } else { // else do Karatsuba
      // if length > 9, do with getProductOf
      long xHigh = firstOperand.getHighHalf();
      long xLow = firstOperand.getLowHalf();
      long yHigh = secondOperand.getHighHalf();
      long yLow = secondOperand.getLowHalf();
      /*System.out.println("xHigh: " + xHigh);
      System.out.println("xLow: " + xLow);
      System.out.println("yHigh: " + yHigh);
      System.out.println("yLow: " + yLow);*/
      // calculate P1 = xh*yh
      long productOne = this.getProductOf(Long.toString(xHigh), Long.toString(yHigh));
      // calculate P2 = xl*yl
      long productTwo = this.getProductOf(Long.toString(xLow), Long.toString(yLow));
      // calculate P3 = (xh+xl)(yh+yl)
      long productThree = this.getProductOf(Long.toString(xHigh + xLow), Long.toString(yHigh + yLow));
      long subtracted = productThree - productTwo - productOne;
      System.out.println("P1: " + productOne);
      System.out.println("P2: " + productTwo);
      System.out.println("P3: " + productThree);
      System.out.println("Sub: " + subtracted);

      //System.out.println("f1: " +Long.parseLong((Long.toString(productOne) + "00000000000")) +"\nf2: "+((subtracted) * Math.pow(10, (numberOfDigits / 2)))+"\nf3: "+productTwo);
      // return P1*10^n + (P3-P2-P1)10^n/2 + P2
      return (long)((productOne * Math.pow(10, numberOfDigits)) + ((productThree - productTwo - productOne) * Math.pow(10, ((int)(numberOfDigits / 2)))) + productTwo);
    }
  }

  private void addFinalProducts(long productOne, long productTwo, long productThree) {

  }
}
