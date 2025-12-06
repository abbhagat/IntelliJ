package geeksforgeeks;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Given a binary array a and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
 * Input: a = [1,1,1,0,0,0,1,1,1,1,0],                 k = 2  Output: 6  Explanation: [1,1,1,0,0,1,1,1,1,1,1]
 * Input: a = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3  Output: 10 Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 */
public class MaxConsecutiveOneInBinaryArrayWithKZeroFlips {

  private static void slidingWindow(int[] a, int k) {
    int j = 0, i = 0, startIndex = 0, bestWindow = 0, zeroCount = 0;
    while (i < a.length) {
      if (zeroCount <= k) {
        zeroCount += a[i] == 0 ? 1 : 0;
        i++;
      }
      if (zeroCount > k) {
        zeroCount -= a[j] == 0 ? 1 : 0;
        j++;
      }
      if (i - j > bestWindow && zeroCount <= k) {
        bestWindow = i - j;
        startIndex = j;
      }
    }
    System.out.print("Index Flipped ");
    IntStream.range(startIndex, startIndex + bestWindow).forEach(l -> {
      if (a[l] == 0) {
        a[l] = 1;
        System.out.print(l + " ");
      }
    });
    System.out.println("\nChanged Array After Flip " + Arrays.toString(a));
    System.out.println("Max Consecutive 1's: " + bestWindow);
  }

  public static void main(String[] args) {
    slidingWindow(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2);
    slidingWindow(new int[]{1, 0, 0, 1, 1, 0, 1, 0, 1, 1}, 2);
    slidingWindow(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3);
  }
}
