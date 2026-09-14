package jpmorgan;

import static java.lang.Integer.max;

public class NextPrimeNumber {

  public static int findNextPrimeNumber(int n) {
    n = max(2, n + 1);
    while (true) {
      if (isPrime(n)) {
        return n;
      }
      n++;
    }
  }

  public static boolean isPrime(int n) {
    if (n <= 1) {
      return false;
    }
    for (int i = 2; i <= n / i; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(findNextPrimeNumber(0));
    System.out.println(findNextPrimeNumber(1));
    System.out.println(findNextPrimeNumber(10));
    System.out.println(findNextPrimeNumber(11));
    System.out.println(findNextPrimeNumber(15));
  }
}
