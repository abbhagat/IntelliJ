package dynamicProgramming;

// Time Complexity: O(3^(m*n))
// Auxiliary Space: O(m + n), for recursive stack space.
public class MinCostPathRecursion {

    private static int minimum(int x, int y, int z) {
        return Math.min(x, Math.min(y, z));
    }

    private static int minCost(int[][] cost, int m, int n) {
        if (m < 0 || n < 0) {
            return Integer.MAX_VALUE;
        }
        if (m == 0 && n == 0) {
            return cost[m][n];
        }
        return cost[m][n] + minimum(minCost(cost, m, n - 1), minCost(cost, m - 1, n - 1), minCost(cost, m - 1, n));
    }

    // Time Complexity: O(m * n), which is much better than Naive Recursive implementation.
    // Auxiliary Space: O(m * n)
    private static int minCostDP(int[][] cost, int m, int n) {
        int[][] tc = new int[m + 1][n + 1];
        tc[0][0] = cost[0][0];
        for (int i = 1; i <= m; i++) {
            tc[i][0] = tc[i - 1][0] + cost[i][0];
        }
        for (int j = 1; j <= n; j++) {
            tc[0][j] = tc[0][j - 1] + cost[0][j];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                tc[i][j] = cost[i][j] + minimum(tc[i - 1][j - 1], tc[i - 1][j], tc[i][j - 1]);
            }
        }
        return tc[m][n];
    }

    public static void main(String[] args) {
        int[][] cost = {
                         {1, 2, 3},
                         {4, 8, 2},
                         {1, 5, 3}
                       };
        System.out.println(minCost(cost, 2, 2) + "\t" + minCostDP(cost, 2, 2));
    }
}
