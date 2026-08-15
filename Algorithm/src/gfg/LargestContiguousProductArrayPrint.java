package gfg;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class LargestContiguousProductArrayPrint {

  private static int maxSubArrayProduct(int[] a) {
    int min = a[0], max = a[0], maxProduct = Integer.MIN_VALUE;
    for (int i = 1; i < a.length; i++) {
      if (a[i] < 0) {
        int t = min;
        min = max;
        max = t;
      }
      min = min(a[i], a[i] * min);
      max = max(a[i], a[i] * max);
      maxProduct = max(maxProduct, max);
    }
    return maxProduct;
  }

  private static int[] maxSubArrayProductPrint(int[] a) {
    int min = a[0], max = a[0], maxProduct = Integer.MIN_VALUE;
    int minStart = 0, maxStart = 0, start = 0, end = 0;
    for (int i = 1; i < a.length; i++) {
      if (a[i] < 0) {
        int temp = min;
        min = max;
        max = temp;

        temp = minStart;
        minStart = maxStart;
        maxStart = temp;
      }
      // Calculate new minimum
      if (a[i] < a[i] * min) {
        min = a[i];
        minStart = i;
      } else {
        min = a[i] * min;
      }
      // Calculate new maximum
      if (a[i] > a[i] * max) {
        max = a[i];
        maxStart = i;
      } else {
        max = a[i] * max;
      }

      // Update global maximum
      if (max > maxProduct) {
        maxProduct = max;
        start = maxStart;
        end = i;
      }
    }
    return new int[]{start, end, maxProduct};
  }

  public static void main(String[] args) {
    System.out.println(maxSubArrayProduct(new int[]{-2, -40, 0, -2, -3}));
    System.out.println(maxSubArrayProduct(new int[]{-1, -2, 10, -10}));
    System.out.println(maxSubArrayProduct(new int[]{2, 3, -2, 4}));
    System.out.println(maxSubArrayProduct(new int[]{-2, 0, -1}));
  }
}
