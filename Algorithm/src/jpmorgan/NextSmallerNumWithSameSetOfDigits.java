package jpmorgan;

import java.util.Arrays;
import java.util.stream.Collectors;
import static util.CommonUtils.swap;

public class NextSmallerNumWithSameSetOfDigits {

  private static int nextPermutation(int n) {
    int[] a = String.valueOf(n).chars().map(c -> c - '0').toArray();
    if (a.length == 1) {
      return n;
    }
    int i;
    for (i = a.length - 1; i > 0; i--) {
      if (a[i] < a[i - 1])
        break;
    }
    if (i != 0) {
      for (int j = a.length - 1; j >= i; j--) {
        if (a[j] < a[i - 1]) {
          swap(a, j, i - 1);
          break;
        }
      }
      int k = a.length - 1;
      int[] b = new int[a.length];
      System.arraycopy(a, 0, b, 0, i);
      for (int j = i; j < b.length; j++) {
        b[j] = a[k];
        k--;
      }
      return Integer.parseInt(Arrays.stream(b)
          .mapToObj(String::valueOf)
          .collect(Collectors.joining()));
    }
    return n;
  }

  public static void main(String[] args) {
    System.out.println(nextPermutation(123));
    System.out.println(nextPermutation(213));
    System.out.println(nextPermutation(312));
    System.out.println(nextPermutation(321));
  }
}
