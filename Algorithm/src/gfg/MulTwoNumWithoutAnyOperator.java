package gfg;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class MulTwoNumWithoutAnyOperator {

  private static int add(int x, int y) {
    return y == 0 ? x : add(x ^ y, (x & y) << 1);
  }

  private static int mul(int x, int y) {
    int mul = 0;
    for (int i = 1; i <= min(x, y); i++) {
      mul = add(mul, max(x, y));
    }
    return mul;
  }

  public static void main(String[] args) {
    System.out.println(mul(3, 15));
    System.out.println(mul(13, 5));
    System.out.println(mul(3, 10));
  }
}
