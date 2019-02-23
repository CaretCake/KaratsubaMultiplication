import java.util.ArrayList;

public class LongInt {
  int numOfDigits;
  ArrayList<String> numberArray = new ArrayList<String>();

  public LongInt (String numberString) {
    this.numOfDigits = numberString.length();
    for (int i = 0; i < numberString.length(); i++) {
      numberArray.add(numberString.charAt(i));
    }
  }

  public long getLongConversion() throws longIntConversionException {
    if (this.numOfDigits > 9) {
      throw new longIntConversionException("LongInt is too large to convert at " + this.numOfDigits + " digits.");
    } else {
      String numberString = "";
      for (char digit : numberArray)  {
        numberString += digit;
      }
      return Long.parseLong(numberString);
    }
  }
}

class longIntConversionException extends Exception {
  public AlsCustomException(String message) {
    super(message);
  }
}
