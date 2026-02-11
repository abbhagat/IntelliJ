package gfg;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class CountProperFraction {

  public static int countProperFractions(int d) {
    int count = 0;
    for (int i = 1; i < d; i++) {
      for (int j = i; j <= d; j++) {
        int hcf = findHCF(i, j);
        if (hcf == 1) {
          count++;
        }
      }
    }
    return count - 1;
  }

  private static int findHCF(int x, int y) {
    return y == 0 ? x : findHCF(y, x % y);
  }

  private static int findGCD(int x, int y) {
    int gcd = 0;
    for (int i = 1; i <= max(x, y); i++) {
      if (x % i == 0 && y % i == 0) {
        gcd = i;
      }
    }
    return gcd;
  }

  public static void main(String[] args) {
    System.out.println(countProperFractions(8));
    System.out.println(findGCD(0, 5));
    System.out.println(findHCF(0, 5));
    System.out.println(findGCD(0, 0));
    System.out.println(findHCF(0, 0));
    System.out.println(findGCD(5, 0));
    System.out.println(findHCF(5, 0));
  }
}
