package geeks;

import static java.lang.Integer.max;

/**
 * Given an integer n, the task is to find the sum:
 * LCM(1, n) + LCM(2, n) + LCM(3, n) + … + LCM(n, n) where LCM(i, n) is the Least Common Multiple of i and n.
 * Examples:
 * Input: 3  Output: LCM(1, 3) + LCM(2, 3) + LCM(3, 3) = 3 + 6 + 3 = 12
 * Input: 5  Output: LCM(1, 5) + LCM(2, 5) + LCM(3, 5) + LCM(4, 5) + LCM(5, 5) = 55
 */

public class LCMSumFrom1toN {

  private static int lcm(int x, int y, int lcm) {
    return lcm % x == 0 && lcm % y == 0 ? lcm : lcm(x, y, lcm + max(x, y));
  }

  private static int findSum(int n) {
    int sum = 0;
    for (int i = 1; i <= n; i++) {
      sum += lcm(i, n, max(i, n));
    }
    return sum;
  }

  public static void main(String[] args) {
    System.out.println(findSum(3));
    System.out.println(findSum(5));
  }
}
