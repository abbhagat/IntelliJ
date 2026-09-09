package jpmorgan;

import static geeks.PrimeNumber.isPrime;
import static java.lang.Integer.max;

public class NextPrimeNumber {

  public static int findNextPrimeNumber(int n) {
    for (int num = max(2, n + 1); ; num++) {
      if (isPrime(num)) {
        return num;
      }
    }
  }

  public static void main(String[] args) {
    System.out.println(findNextPrimeNumber(0));
    System.out.println(findNextPrimeNumber(1));
    System.out.println(findNextPrimeNumber(10));
    System.out.println(findNextPrimeNumber(11));
    System.out.println(findNextPrimeNumber(15));
  }
}
