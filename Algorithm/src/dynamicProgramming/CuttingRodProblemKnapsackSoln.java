package dynamicProgramming;

import java.util.Arrays;
import static java.lang.Integer.max;

// Time  Complexity: O(w * n)
// Space Complexity: O(n)
public class CuttingRodProblemKnapsackSoln {

  private static int cutRod(int[] price) {
    int[] wt = new int[price.length];
    Arrays.setAll(wt, i -> i + 1);
    final int w = wt.length, n = price.length;
    int[] dp = new int[w + 1];
    for (int i = 0; i <= w; i++) {
      for (int j = 0; j < n; j++) {
        if (i >= wt[j]) {
          dp[i] = max(dp[i], dp[i - wt[j]] + price[j]);
        }
      }
    }
    return dp[w];
  }

  public static void main(String[] args) {
    System.out.println(cutRod(new int[]{1, 5, 8, 9, 10, 17, 17, 20}));
  }
}
