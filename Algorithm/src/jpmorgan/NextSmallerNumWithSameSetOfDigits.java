package jpmorgan;

import static util.CommonUtils.swap;
import static util.CommonUtils.reverse;

// Time  Complexity : O(n)
// Space Complexity : O(n)
public class NextSmallerNumWithSameSetOfDigits {

  private static int nextPermutation(int n) {
    char[] c = String.valueOf(n).toCharArray();
    int i = c.length - 2;
    while (i >= 0 && c[i] <= c[i + 1]) {
      i--;
    }
    if (i < 0) {
      return n;
    }
    int j = c.length - 1;
    while (c[j] >= c[i]) {
      j--;
    }
    swap(c, i, j);
    reverse(c, i + 1, c.length - 1);
    return Integer.parseInt(new String(c));
  }

  public static void main(String[] args) {
    System.out.println(nextPermutation(123));
    System.out.println(nextPermutation(213));
    System.out.println(nextPermutation(312));
    System.out.println(nextPermutation(321));
  }
}
