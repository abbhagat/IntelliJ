package dynamicProgramming;

import static java.lang.Integer.min;

/**
 * Given N non-negative integers which signifies the cost of the moving from each stair.
 * Paying the cost at i-th step, you can either climb one or two steps.
 * Given that one can start from the 0-the step or 1-the step, the task is to find the minimum cost to reach the top of the floor(N+1) by climbing N stairs.
 * Input: a[] = { 16, 19, 10, 12, 18 }
 * Output: 31
 * Start from 19 and then move to 12.
 * Input: a[] = {2, 5, 3, 1, 7, 3, 4}
 * Output: 9
 * 2->3->1->3
 */
public class MinCostToReachTopFloor {

    private static int minCost(int[] a) {
        int n = a.length;
        int[] dp = new int[n + 1];
        if (n == 1) {
            return a[0];
        }
        dp[0] = a[0];
        dp[1] = a[1];
        for (int i = 2; i < n; i++) {
            dp[i] = a[i] + min(dp[i - 1], dp[i - 2]);
        }
        return min(dp[n - 1], dp[n - 2]);
    }

    private static int minCost(int[] a, int n) {
        switch (n) {
            case 1:  return a[0];
            case 2:  return a[1];
            default: return a[n - 1] + min(minCost(a, n - 1), minCost(a, n - 2));
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{16, 19, 10, 12, 18};
        System.out.println(minCost(a) + "\t" + minCost(a, a.length - 1));
        a = new int[]{2, 5, 3, 1, 7, 3, 4};
        System.out.println(minCost(a) + "\t" + minCost(a, a.length - 1));
    }
}
