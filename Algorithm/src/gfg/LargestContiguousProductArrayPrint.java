package gfg;

import java.util.Arrays;
import java.util.stream.IntStream;

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

  private static void maxSubArrayProductPrint(int[] a) {
    int min = a[0], max = a[0], maxProduct = Integer.MIN_VALUE;
    int minStart = 0, maxStart = 0, start = 0, end = 0;
    for (int i = 1; i < a.length; i++) {
      if (a[i] < 0) {
        // swap min with max
        int t = min;
        min = max;
        max = t;
       // swap minStart with maxStart
        t = minStart;
        minStart = maxStart;
        maxStart = t;
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
    System.out.println(maxProduct);
    System.out.println(Arrays.toString(Arrays.copyOfRange(a, start, end + 1)));
  }

  public static void main(String[] args) {
    int[] a = new int[]{-2, -40, 0, -2, -3};
    maxSubArrayProductPrint(a);
    maxSubArrayProduct(a);
    System.out.println(maxSubArrayProduct(new int[]{-1, -2, 10, -10}));
    System.out.println(maxSubArrayProduct(new int[]{2, 3, -2, 4}));
    System.out.println(maxSubArrayProduct(new int[]{-2, 0, -1}));
  }
}
