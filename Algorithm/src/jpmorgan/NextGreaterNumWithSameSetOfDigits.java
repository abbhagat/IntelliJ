package jpmorgan;

import static util.CommonUtils.swap;

// Time  Complexity : O(n)
// Space Complexity : O(n)
public class NextGreaterNumWithSameSetOfDigits {

  private static int nextPermutation(int n) {
    char[] a = String.valueOf(n).toCharArray();
    int i = a.length - 2;
    while (i >= 0 && a[i] >= a[i + 1]) {
      i--;
    }
    if (i < 0) {
      return n;
    }
    int j = a.length - 1;
    while (a[j] <= a[i]) {
      j--;
    }
    swap(a, i, j);
    reverse(a, i + 1, a.length - 1);
    return Integer.parseInt(new String(a));
  }

  private static void reverse(char[] a, int l, int r) {
    while (l < r) {
      swap(a, l++, r--);
    }
  }

  public static void main(String[] args) {
    System.out.println(nextPermutation(123));
    System.out.println(nextPermutation(213));
    System.out.println(nextPermutation(312));
    System.out.println(nextPermutation(321));
  }
}
