package dynamicProgramming;

// Time Complexity : O(n)
// Auxiliary Space : O(n)
public class DifferentWaysToExpressNAsSumOf134 {

    private static int countWays(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = dp[2] = 1;
        dp[3] = 2;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 3] + dp[i - 4];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(countWays(4));
        System.out.println(countWays(5));
    }
}
