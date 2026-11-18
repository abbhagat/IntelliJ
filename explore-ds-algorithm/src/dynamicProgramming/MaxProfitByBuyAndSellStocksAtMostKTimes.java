package dynamicProgramming;

import static java.lang.Integer.max;

public class MaxProfitByBuyAndSellStocksAtMostKTimes {

  private static int maxProfit(int[] price, final int k) {
    int n = price.length - 1;
    int[][] dp = new int[k + 1][n + 1];
    for (int i = 0; i <= k; i++) {    // For day 0, you can't earn money irrespective of how many times you trade
      dp[i][0] = 0;
    }
    for (int j = 0; j <= n; j++) {  // profit is 0 if we don't do any transaction (i.e., k = 0)
      dp[0][j] = 0;
    }
    for (int i = 1; i <= k; i++) {
      int prevDiff = Integer.MIN_VALUE;
      for (int j = 1; j <= n; j++) {
        prevDiff = max(prevDiff, dp[i - 1][j - 1] - price[j - 1]);
        dp[i][j] = max(dp[i][j - 1], price[j] + prevDiff);
      }
    }
    return dp[k][n];
  }

  public static void main(String[] args) {
    System.out.println(maxProfit(new int[]{100, 30, 15, 10, 8, 25, 80}, 2));
    System.out.println(maxProfit(new int[]{90, 80, 70, 60, 50}, 2));
    System.out.println(maxProfit(new int[]{2, 30, 15, 10, 8, 25, 80}, 2));
    System.out.println(maxProfit(new int[]{10, 22, 5, 75, 65, 80}, 2));
    System.out.println(maxProfit(new int[]{1, 2, 3, 4, 5}, 2));
  }
}
