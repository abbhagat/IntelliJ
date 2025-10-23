package dynamicProgramming;

import static util.CommonUtils.minimum;

// Time Complexity: O(3^(m*n))
// Auxiliary Space: O(m + n), for recursive stack space.
public class MinCostPathRecursion {

  private static int minCost(int[][] cost, int m, int n) {
    if (m < 0 || n < 0) {
      return Integer.MAX_VALUE;
    }
    if (m == 0 && n == 0) {
      return cost[m][n];
    }
    int x = minCost(cost, m, n - 1);
    int y = minCost(cost, m - 1, n - 1);
    int z = minCost(cost, m - 1, n);
    return cost[m][n] + minimum(x, y, z);
  }

  private static int minCost(int[][] cost, int m, int n, int R, int C) {
    if (m > R || n > C) {
      return Integer.MAX_VALUE;
    }
    if (m == R && n == C) {
      return cost[m][n];
    }
    int x = minCost(cost, m, n + 1, R, C);
    int y = minCost(cost, m + 1, n + 1, R, C);
    int z = minCost(cost, m + 1, n, R, C);
    return cost[m][n] + minimum(x, y, z);
  }

  // Time Complexity : O(m * n), which is much better than Naive Recursive implementation.
  // Auxiliary Space : O(m * n)
  private static int minCostDP(int[][] cost) {
    int m = cost.length, n = cost[0].length;
    int[][] tc = new int[m][n];
    tc[0][0] = cost[0][0];
    for (int i = 1; i < m; i++) {
      tc[i][0] = tc[i - 1][0] + cost[i][0];
    }
    for (int j = 1; j < n; j++) {
      tc[0][j] = tc[0][j - 1] + cost[0][j];
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        tc[i][j] = cost[i][j] + minimum(tc[i - 1][j - 1], tc[i - 1][j], tc[i][j - 1]);
      }
    }
    return tc[m - 1][n - 1];
  }

  public static void main(String[] args) {
    int[][] cost = {
        {1, 2, 3},
        {4, 8, 2},
        {1, 5, 3}
    };
    int ROW = cost.length - 1;
    int COL = cost[0].length - 1;
    System.out.println(minCost(cost, ROW, COL) + "\t" + minCostDP(cost) + "\t" + minCost(cost, 0, 0, ROW, COL));
  }
}
