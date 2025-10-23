package vmware;

import static java.lang.Math.log10;

public class IsGivenNumPowerOfK {

  private static boolean isPowerOfK(int n, int k) {
    if (n < 1) {
      return false;
    }
    while (n % k == 0) {
      n /= k;
    }
    return n == 1;
  }

  private static boolean isPowerOfTwo(int n) {
    return n > 0 && (n & (n - 1)) == 0;
  }

  private static boolean isPowerOfThree(int n) {
    return (log10(n) / log10(3)) % 1 == 0;
  }

  private static boolean isPowerOfFour(int n) {
    return (n & (n - 1)) == 0 && n % 3 == 1;
  }

  public static void main(String[] args) {
    System.out.println(isPowerOfK(4, 2) + "\t" + isPowerOfTwo(4));
    System.out.println(isPowerOfK(81, 3) + "\t" + isPowerOfThree(81));
    System.out.println(isPowerOfK(9, 3) + "\t" + isPowerOfThree(9));
    System.out.println(isPowerOfK(16, 4) + "\t" + isPowerOfFour(16));
    System.out.println(isPowerOfK(256, 4) + "\t" + isPowerOfFour(256));
  }
}
