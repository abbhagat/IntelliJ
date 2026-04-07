package matrix;

import static java.lang.Integer.max;
import static util.CommonUtils.maximum;

/**
 * Given a gold mine of ROW * COL dimensions. Each field in this mine contains a positive integer which is the amount of gold in tons.
 * Initially, the miner is at first column but can be at any row. He can move only (right,right up,right down)
 * that is from a given cell, the miner can move to the cell diagonally up towards the right or diagonally down towards the right.
 * Find out the maximum amount of gold he can collect.
 * Input: M[][] =    {{1, 3, 3},
 *                    {2, 1, 4},
 *                    {0, 6, 4}
 *                   };
 * Output: 12 {(1,0)->(2,1)->(1,2)}
 * Input: M[][] =  {  {1, 3, 1, 5},
 * {2, 2, 4, 1},
 * {5, 0, 2, 3},
 * {0, 6, 1, 2}
 * };
 * Output : 16  (2,0) -> (1,1) -> (1,2) -> (0,3) OR (2,0) -> (3,1) -> (2,2) -> (2,3)
 * Input: M[][] = {
 * {10, 33, 13, 15},
 * {22, 21, 04, 1},
 * {5,   0,  2, 3},
 * {0,   6, 14, 2}
 * };
 * Output: 83
 * A miner can start from any row in the first column of a gold mine and can move only right, right-up or right-down.
 * The goal is to find the maximum amount of gold that can be collected by the miner.
 * Approach: Dynamic Programming
 * 1.Create a table to store the maximum gold that can be collected when starting from each cell.
 * 2.Fill the table by considering the three possible moves (right, right-up, right-down).
 * 3.The answer will be the maximum value in the first column of the table.
 */
public class GoldMineProblem {

  // O(3^COL) (exponential ❌)
  private static int getMaxGoldRec(int[][] gold) {
    int ROW = gold.length, COL = gold[0].length;
    int max = Integer.MIN_VALUE;
    for (int row = 0; row < ROW; row++) {     // Try starting from each row in first column
      max = max(max, maxGold(gold, row, 0, ROW, COL));
    }
    return max;
  }

  private static int maxGold(int[][] gold, int row, int col, int ROW, int COL) {
    if (row < 0 || row >= ROW || col < 0 || col >= COL) {
      return 0;
    }
    int right     = maxGold(gold, row, col + 1, ROW, COL);
    int rightUp   = maxGold(gold, row - 1, col + 1, ROW, COL);
    int rightDown = maxGold(gold, row + 1, col + 1, ROW, COL);
    return gold[row][col] + maximum(right, rightUp, rightDown);
  }

  // Returns maximum amount of gold that can be collected when a journey started from the first column and moves allowed are right, right-up and right-down
  private static int getMaxGold(int[][] gold) {
    int ROW = gold.length, COL = gold[0].length;
    int[][] dp = new int[ROW][COL];
    for (int col = COL - 1; col >= 0; col--) {
      for (int row = 0; row < ROW; row++) {
        int right           =                   col == COL - 1 ? 0 : dp[row]    [col + 1];    // Gold collected on going to the cell on the right
        int right_up        = row == 0       || col == COL - 1 ? 0 : dp[row - 1][col + 1];   // Gold collected on going to the cell to right up
        int right_down      = row == ROW - 1 || col == COL - 1 ? 0 : dp[row + 1][col + 1];  // Gold collected on going to the cell to right down
        dp[row][col] = gold[row][col] + maximum(right, right_up, right_down);              // Max gold collected from taking either of the above 3 paths
      }
    }
    int max = dp[0][0];
    for (int[] a : dp) {
      max = max(max, a[0]);   // The max amount of gold collected will be the max value in the first column of all rows
    }
    return max;
  }

  public static void main(String[] arg) {
    int[][] gold1 = {
        {1, 3, 1, 5},
        {2, 2, 4, 1},
        {5, 0, 2, 3},
        {0, 6, 1, 2}
    };
    System.out.println(getMaxGold(gold1) + "\t" + getMaxGoldRec(gold1));

   int[][] gold2 = {
        {10, 33, 13, 15},
        {22, 21,  4, 1},
        {5,   0,  2, 3},
        {0,   6, 14, 2}
    };
    System.out.println(getMaxGold(gold2) + "\t" + getMaxGoldRec(gold2));
  }
}
