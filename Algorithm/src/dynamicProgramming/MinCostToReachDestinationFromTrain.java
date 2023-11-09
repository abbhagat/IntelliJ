package dynamicProgramming;

import java.util.Arrays;

import static java.lang.Integer.min;

public class MinCostToReachDestinationFromTrain {
    private static final int MAX = Integer.MAX_VALUE;

    private static int minCost(int[][] cost, int s, int d) {
        if (s == d || s + 1 == d) {  // If source is same as destination or destination is next to source
            return cost[s][d];
        }
        int min = cost[s][d];   // Initialize min cost as direct ticket from source 's' to destination 'd'.
        for (int i = s + 1; i < d; i++) {
            int result = minCost(cost, s, i) + minCost(cost, i, d);
            min = min(min, result);
        }
        return min;
    }

    private static int minCost(int[][] cost) {
        final int N = cost.length;
        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (dp[j] > dp[i] + cost[i][j]) {
                    dp[j] = dp[i] + cost[i][j];
                }
            }
        }
        return dp[N - 1];
    }

    public static void main(String[] args) {
        final int[][] cost = {
                               {0, 15, 80, 90},
                               {MAX, 0, 40, 50},
                               {MAX, MAX, 0, 70},
                               {MAX, MAX, MAX, 0}
                             };
        final int N = cost.length;
        System.out.println(minCost(cost, 0, N - 1) + "\t" + minCost(cost));
    }
}
