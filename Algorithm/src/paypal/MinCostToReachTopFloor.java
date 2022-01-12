package paypal;

/**
 * Given N non-negative integers which signifies the cost of the moving from each stair.
 * Paying the cost at i-th step, you can either climb one or two steps.
 * Given that one can start from the 0-the step or 1-the step, the task is to find the minimum cost to reach the top of the floor(N+1) by climbing N stairs.
 */
public class MinCostToReachTopFloor {

    private static int minCost(int[] a, int n) {
        int[] dp = new int[n];
        if (n == 1) {
            return a[0];
        }
        dp[0] = a[0];
        dp[1] = a[1];
        for (int i = 2; i < n; i++) {
            dp[i] = a[i] + Integer.min(dp[i - 1], dp[i - 2]);
        }
        return Integer.min(dp[n - 1], dp[n - 2]);
    }

    public static void main(String[] args) {
        System.out.println(minCost(new int[]{16, 19, 10, 12, 18},  5));
        System.out.println(minCost(new int[]{2, 5, 3, 1, 7, 3, 4}, 7));
    }
}
