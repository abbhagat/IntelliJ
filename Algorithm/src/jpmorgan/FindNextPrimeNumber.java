package jpmorgan;

public class FindNextPrimeNumber {

  public static int findNextPrimeNumber(int n) {
    n = n <= 1 ? 2 : n + 1;
    for (int i = 2; i <= n / 2; i++) {
      if (n % i == 0) {
        n++;
        i = 2;
      }
    }
    return n;
  }

  public static void main(String[] args) {
    System.out.println(findNextPrimeNumber(0));
    System.out.println(findNextPrimeNumber(1));
    System.out.println(findNextPrimeNumber(10));
    System.out.println(findNextPrimeNumber(11));
    System.out.println(findNextPrimeNumber(15));
  }
}
