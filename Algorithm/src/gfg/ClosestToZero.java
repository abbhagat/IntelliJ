package gfg;

import static java.lang.Math.abs;

public class ClosestToZero {

  public static void main(String[] args) {
    int[] a = {1, 7, 9, 4, 2, -1};
    int closest = a[0];
    for (int i = 1; i < a.length; i++) {
      if (abs(a[i]) <= abs(closest)) {
        closest = a[i];
      }
    }
    System.out.println(closest);
  }
}
