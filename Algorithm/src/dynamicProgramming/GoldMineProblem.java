package dynamicProgramming;

import static java.lang.Integer.max;
import static util.CommonUtils.maximum;

/*
Given a gold mine of ROW * COL dimensions. Each field in this mine contains a positive integer which is the amount of gold in tons.
Initially the miner is at first column but can be at any row. He can move only (right,right up,right down)
that is from a given cell, the miner can move to the cell diagonally up towards the right or diagonally down towards the right.
Find out maximum amount of gold he can collect.

Input : mat[][] = {{1, 3, 3},
                   {2, 1, 4},
                  {0, 6, 4}};
Output : 12
{(1,0)->(2,1)->(1,2)}

Input: mat[][] = { {1, 3, 1, 5},
                   {2, 2, 4, 1},
                   {5, 0, 2, 3},
                   {0, 6, 1, 2}
                };
Output : 16
(2,0) -> (1,1) -> (1,2) -> (0,3) OR
(2,0) -> (3,1) -> (2,2) -> (2,3)

Input : mat[][] = {{10, 33, 13, 15},
                  {22, 21, 04, 1},
                  {5, 0, 2, 3},
                  {0, 6, 14, 2}};
Output : 83
 */
public class GoldMineProblem {

  // O(3^COL) (exponential ❌)
  private static int getMaxGoldRec(int[][] gold) {
    int ROW = gold.length, COL = gold[0].length;
    int max = Integer.MIN_VALUE;
    for (int row = 0; row < ROW; row++) {     // Try starting from each row in first column
      max = max(max, dfs(gold, row, 0, ROW, COL));
    }
    return max;
  }

  private static int dfs(int[][] gold, int row, int col, int ROW, int COL) {
    if (row < 0 || row >= ROW || col < 0 || col >= COL) {
      return 0;
    }
    int right     = dfs(gold, row, col + 1, ROW, COL);
    int rightUp   = dfs(gold, row - 1, col + 1, ROW, COL);
    int rightDown = dfs(gold, row + 1, col + 1, ROW, COL);
    return gold[row][col] + maximum(right, rightUp, rightDown);
  }

  // Returns maximum amount of gold that can be collected when journey started from first column and moves allowed are right, right-up and right-down
  private static int getMaxGold(int[][] gold) {
    // The first row of goldMineTable gives the maximum gold that the miner can collect when starts that row
    int ROW = gold.length, COL = gold[0].length;
    int[][] dp = new int[ROW][COL];
    for (int j = COL - 1; j >= 0; j--) {
      for (int i = 0; i < ROW; i++) {
        int right      = j == COL - 1                ? 0 : dp[i]    [j + 1];    // Gold collected on going to the cell on the right
        int rightUp   = i == 0 || j == COL - 1       ? 0 : dp[i - 1][j + 1];   //  Gold collected on going to the cell to right up
        int rightDown = i == ROW - 1 || j == COL - 1 ? 0 : dp[i + 1][j + 1];  //   Gold collected on going to the cell to right down
        dp[i][j] = gold[i][j] + maximum(right, rightUp, rightDown);          //    Max gold collected from taking either of the above 3 paths
      }
    }
    int max = dp[0][0];
    for (int[] a : dp) {
      max = max(max, a[0]);   // The max amount of gold collected will be the max value in first column of all rows
    }
    return max;
  }

  public static void main(String[] arg) {
    System.out.println(getMaxGold(new int[][]{
        {1, 3, 1, 5},
        {2, 2, 4, 1},
        {5, 0, 2, 3},
        {0, 6, 1, 2}
    }));
    System.out.println(getMaxGold(new int[][]{
        {10, 33, 13, 15},
        {22, 21, 4, 1},
        {5, 0, 2, 3},
        {0, 6, 14, 2}
    }));
  }
}
