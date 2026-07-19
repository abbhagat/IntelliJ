package leetcode;

import static java.lang.Integer.max;

public class RotateFunction {

  private static int rotate(int[] a) {
    int sum = 0, k = 0;
    for (int i = 0; i < a.length; i++) {
      k += i * a[i];
      sum += a[i];
    }
    int max = k;
    for (int i = a.length - 1; i > 0; i--) {
      k += sum - a.length * a[i];
      max = max(max, k);
    }
    return max;
  }

  public static void main(String[] args) {
    System.out.println(rotate(new int[]{4, 3, 2, 6}));
  }
}
