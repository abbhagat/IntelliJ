package dynamicProgramming;

import java.util.Arrays;
import static java.lang.Integer.max;

// Time  Complexity: O(n * n)
// Space Complexity: O(n)
public class CuttingRodProblemKnapsackSoln {

  private static int cutRod(int[] price) {
    int    n = price.length;
    int[] dp = new int[n + 1];
    int[] wt = new int[n];
    Arrays.setAll(wt, i -> i + 1);
    for (int i = 0; i <= n; i++) {    // iterate the dp array
      for (int j = 0; j < n; j++) {  // iterate the price array
        if (i >= wt[j]) {
          dp[i] = max(dp[i], dp[i - wt[j]] + price[j]);
        }
      }
    }
    return dp[n];
  }

  public static void main(String[] args) {
    System.out.println(cutRod(new int[]{1, 5, 8, 9, 10, 17, 17, 20}));
    System.out.println(cutRod(new int[]{1, 2, 3, 4, 5}));
  }
}
