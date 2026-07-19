package leetcode;

import java.util.Arrays;

// Time  Complexity: O(n log n)
// Space Complexity: O(1)
public class SummaryRanges {

  private static void printSummaryRanges(int[] a) {
    Arrays.sort(a);
    int start = a[0], i;
    for (i = 1; i < a.length; i++) {
      if (a[i] - a[i - 1] != 1) {
        System.out.println(start == a[i - 1] ? start : (start + "-" + a[i - 1]));
        start = a[i];
      }
    }
    System.out.println(start == a[i - 1] ? start : (start + "-" + a[i - 1]));
  }

  public static void main(String[] args) {
    printSummaryRanges(new int[]{0, 1, 2, 4, 5, 7});
    System.out.println();
    printSummaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9});
  }
}
