package dynamicProgramming;

import java.util.Arrays;

import static java.lang.Integer.min;

public class MinCoinToMakeAValue {

  // Time  Complexity : O(V^m) where V is the value and m is the number of coin
  // Space Complexity : O(V) for recursion stack space
  private static int minCoins(int[] coins, final int V) {
    if (V == 0) {
      return 0;
    }
    int min = Integer.MAX_VALUE;
    for (int coin : coins) {
      if (coin <= V) {
        int result = 1 + minCoins(coins, V - coin);
        min = min(min, result);
      }
    }
    return min;
  }

  // Time Complexity  : O(m*V)
  // Space Complexity : O(V)
  private static int minCoinsDP(int[] coins, int V) {
    int[] dp = new int[V + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int i = 1; i <= V; i++) {
      for (int coin : coins)
        if (coin <= i) {
          int result = dp[i - coin];
          if (result != Integer.MAX_VALUE && dp[i] > result + 1) {
            dp[i] = result + 1;
          }
        }
    }
    return dp[V] == Integer.MAX_VALUE ? -1 : dp[V];
  }

  public static void main(String[] args) {
    System.out.println(minCoins(new int[]{9, 6, 5, 1}, 11) + "\t" + minCoinsDP(new int[]{9, 6, 5, 1}, 11));
    System.out.println(minCoins(new int[]{25, 10, 5}, 30) + "\t" + minCoinsDP(new int[]{25, 10, 5}, 30));
    System.out.println(minCoins(new int[]{9, 6, 5, 1}, 21) + "\t" + minCoinsDP(new int[]{9, 6, 5, 1}, 21));
  }
}
