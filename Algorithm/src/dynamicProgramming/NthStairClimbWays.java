package dynamicProgramming;

/**
 * There are n stairs, a person standing at the bottom wants to reach the top.
 * The person can climb either 1 stair or 2 stairs at a time.
 * Count the number of ways, the person can reach the top.
 * ways(n) = ways(n-1) + ways(n-2)
 */
public class NthStairClimbWays {

  // Time  Complexity: O(n)
  // Space Complexity: O(n)
  private static int stairCountDP(int n) {
    int[] dp = new int[n + 1];
    if (n == 0) {
      return dp[0];
    }
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }

  // Time  Complexity: O(2^n)
  // Space Complexity: O(n)
  private static int stairCount(int n) {
    return switch (n) {
      case 0 -> 0;
      case 1 -> 1;
      case 2 -> 2;
      default -> stairCount(n - 1) + stairCount(n - 2);
    };
  }

  public static void main(String[] args) {
    System.out.println(stairCount(0) + "\t" + stairCountDP(0));
    System.out.println(stairCount(4) + "\t" + stairCountDP(4));
    System.out.println(stairCount(5) + "\t" + stairCountDP(5));
    System.out.println(stairCount(6) + "\t" + stairCountDP(6));
  }

}
