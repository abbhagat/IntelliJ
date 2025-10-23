package gfg;

public class SubTwoNumWithoutAnyOperator {

  private static int sub(int x, int y) {
    while (y != 0) {
      int carry = (~x & y) << 1;
      x = x ^ y;
      y = carry;
    }
    return x;
  }

  private static int subtract(int x, int y) {
    return y == 0 ? x : subtract(x ^ y, (~x & y) << 1);
  }

  public static void main(String[] args) {
    int x = 13;
    int y = 5;
    System.out.println(x + ~y + 1);
    System.out.println(sub(x, y));
    System.out.println(subtract(x, y));
    System.out.println(subtract(y, x));
  }
}
