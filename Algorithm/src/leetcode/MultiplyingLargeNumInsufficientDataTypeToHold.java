package leetcode;

import java.util.stream.IntStream;

public class MultiplyingLargeNumInsufficientDataTypeToHold {

  private static void multiplyArrays(int[] x, int[] y) {
    int k = x.length + y.length;
    int[] mul = new int[k];
    for (int i = x.length - 1; i >= 0; i--) {
      int carry = 0, sum;
      for (int j = y.length - 1; j >= 0; j--) {
        sum      = x[i] * y[j] + carry + mul[k - 1];
        carry    = sum / 10;
        mul[--k] = sum % 10;
      }
      mul[--k] = carry;
      k += y.length;
    }
    int start = 0;
    for (int n : mul) {
      if (n == 0) {
        start++;
      } else {
        break;
      }
    }
    IntStream.range(start, mul.length).forEach(i -> System.out.print(mul[i]));
    System.out.println();
  }

  public static void main(String[] args) {
    multiplyArrays(new int[]{1, 2}, new int[]{1, 0});
    multiplyArrays(new int[]{2, 5}, new int[]{2, 5});
  }
}
