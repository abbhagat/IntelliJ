package gfg;

import static java.lang.Math.abs;

public class ClosestNumberInAnArray {

  private static int closestNumber(int[] a, int k) {
    int closest = a[0];
    for (int i = 1; i < a.length; i++) {
      if (abs(a[i] - k) <= abs(closest - k)) {
        closest = a[i];
      }
    }
    return closest;
  }

  public static void main(String[] args) {
    int[] a = {3, 2, 9, 4, 10, 1, 7};
    System.out.println(closestNumber(a, 5));
    System.out.println(closestNumber(a, 8));
  }
}
