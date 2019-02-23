import java.util.ArrayList;

public class LongInt {
  int numOfDigits;
  ArrayList<Integer> numberArray = new ArrayList<Integer>();

  public LongInt (String numberString) {
    this.numOfDigits = numberString.length();
    for (int i = 0; i < numberString.length(); i++) {
      numberArray.add(numberString.charAt(i) - '0');
    }
  }
}
