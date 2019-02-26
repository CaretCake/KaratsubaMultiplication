import java.util.ArrayList;

public class LongInt {
  int numOfDigits;
  ArrayList<Character> numberArray = new ArrayList<Character>();

  public LongInt (String numberString) {
    this.numOfDigits = numberString.length();
    for (int i = 0; i < numberString.length(); i++) {
      numberArray.add(numberString.charAt(i));
    }
  }

  public boolean isValidLong() {
    return this.numOfDigits > 9 ? false : true;
  }

  public long getLongConversion() throws longIntConversionException {
    if (this.isValidLong()) {
      // TODO: refactor string creation from arraylist into a method
      String numberString = "";
      for (char digit : numberArray)  {
        numberString += digit;
      }
      return Long.parseLong(numberString);
    } else {
      throw new longIntConversionException("LongInt is too large to convert at " + this.numOfDigits + " digits.");
    }
  }

  public long getHighHalf() {
    String numberString = "";
    for (int i = 0; i < numberArray.size()/2; i++) {
      numberString += numberArray.get(i);
    }
    return Long.parseLong(numberString);
  }

  public long getLowHalf() {
    String numberString = "";
    for (int i = numberArray.size()/2; i < numberArray.size(); i++) {
      numberString += numberArray.get(i);
    }
    return Long.parseLong(numberString);
  }

  public String getStringFromArray() {
    return "";
  }
}
