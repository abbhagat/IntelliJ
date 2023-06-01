package dynamicProgramming;

// Time Complexity : O(n)
// Auxiliary Space : O(n)
public class DifferentWaysToExpressNAsSumOf134 {

    public static void main(String[] args) {
        int n = 4;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = dp[2] = 1;
        dp[3] = 2;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 3] + dp[i - 4];
        }
        System.out.println(dp[n]);
    }
}
