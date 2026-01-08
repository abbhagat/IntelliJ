package adobe;

import static java.lang.Integer.max;

/**
 * Input: a = {2, 3, 10, 6, 4, 8, 1} Output: 8  Explanation: The maximum difference is between 10 and 2.
 * Input: a = {7, 9, 5, 6, 3, 2}     Output: 2  Explanation: The maximum difference is between  9 and 7.
 */

// Time Complexity : O(n)
// Auxiliary Space : O(1)
public class MaxDiffBtwTwoElementSuchThatLargerElementAppearsAfterSmallerNumber {

  private static int maxDiff(int[] a) {
    int prevDiff = a[1] - a[0], maxDiff = prevDiff;
    for (int i = 2; i < a.length; i++) {
      int currDiff = a[i] - a[i - 1];
      prevDiff = prevDiff > 0 ? prevDiff + currDiff : currDiff;
      maxDiff = max(maxDiff, prevDiff);
    }
    return maxDiff;
  }

  public static void main(String[] args) {
    System.out.println(maxDiff(new int[]{4, 21, 3, 15, 10, 21}));
    System.out.println(maxDiff(new int[]{2, 3, 10, 6, 4, 8, 1}));
    System.out.println(maxDiff(new int[]{7, 9, 5, 6, 3, 2}));
  }
}
