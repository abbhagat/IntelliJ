package geeks;

import java.util.HashMap;
import java.util.Map;
import static util.CommonUtils.printArray;

// Time  Complexity: O(n)
// Space Complexity: O(n)
public class LongestZeroSumSubArray {

  private static class Index {
    int start;
    int end;
  }

  private static void longestSumSubArray(int[] a, int n, Index index) {
    Map<Integer, Integer> map = new HashMap<>();  // to store key as sum and the value as index i
    int sum = 0, max = 0;
    for (int i = 0; i < a.length; i++) {
      sum += a[i];
      if (sum == n) {
        max = i + 1;
        index.start = 0;
        index.end = i;
      }
      if (map.containsKey(sum)) {
        int length = i - map.get(sum);
        if (max < length) {
          max = length;
          index.start = map.get(sum) + 1;
          index.end = i;
        }
      } else {
        map.put(sum, i);
      }
    }
    System.out.print("Max SubArray ");
    printArray(a, index.start, index.end + 1);
    System.out.println("Length : " + max);
  }

  public static void main(String[] args) {
    longestSumSubArray(new int[]{-1, 0, 1}, 0, new Index());
    longestSumSubArray(new int[]{15, -2, 2, -8, 1, 7, 10, 23}, 0, new Index());
    longestSumSubArray(new int[]{15, -2, 2, -8, 1, 7, 10, 23}, 25, new Index());
    longestSumSubArray(new int[]{15, -2, 2, -8, 1, 7, 10, 23}, 33, new Index());
    longestSumSubArray(new int[]{1, -2, 2, -8, 1, 7, -1}, 0, new Index());
    longestSumSubArray(new int[]{1, -2, 2, -8, 1, 7, -1}, 1, new Index());
  }
}
