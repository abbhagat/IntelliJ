package matrix;

import static java.lang.Integer.max;
import static util.CommonUtils.maximum;

/**
Given a gold mine of ROW*COL dimensions. Each field in this mine contains a positive integer which is the amount of gold in tons.
Initially, the miner is at first column but can be at any row. He can move only (right,right up,right down)
that is from a given cell, the miner can move to the cell diagonally up towards the right or diagonally down towards the right.
Find out the maximum amount of gold he can collect.

Input: M[][] = {{1, 3, 3},
                   {2, 1, 4},
                  {0, 6, 4}};
Output: 12 {(1,0)->(2,1)->(1,2)}

Input: M[][] = { {1, 3, 1, 5},
                   {2, 2, 4, 1},
                   {5, 0, 2, 3},
                   {0, 6, 1, 2}
                };
Output : 16  (2,0) -> (1,1) -> (1,2) -> (0,3) OR (2,0) -> (3,1) -> (2,2) -> (2,3)

Input: M[][] = {
                {10, 33, 13, 15},
                {22, 21, 04, 1},
                {5,   0,  2, 3},
                {0,   6, 14, 2}
 };
Output: 83
A miner can start from any row in the first column of a gold mine and can move only right, right-up or right-down.
The goal is to find the maximum amount of gold that can be collected by the miner.
Approach: Dynamic Programming
1.Create a table to store the maximum gold that can be collected when starting from each cell.
2.Fill the table by considering the three possible moves (right, right-up, right-down).
3.The answer will be the maximum value in the first column of the table.
*/
public class GoldMineProblem {

    // Returns maximum amount of gold that can be collected when a journey started from the first column and moves allowed are right, right-up and right-down
    private static int getMaxGold(int[][] gold) {
        // The first row of goldMineTable gives the maximum gold that the miner can collect when starts that row
        int ROW = gold.length, COL = gold[0].length;
        int[][] goldTable = new int[ROW][COL];
        for (int col = COL - 1; col >= 0; col--) {
            for (int row = 0; row < ROW; row++) {
                 int right           =                   col == COL - 1 ? 0 : goldTable[row]    [col + 1];    // Gold collected on going to the cell on the right
                 int right_up        = row == 0       || col == COL - 1 ? 0 : goldTable[row - 1][col + 1];   // Gold collected on going to the cell to right up
                 int right_down      = row == ROW - 1 || col == COL - 1 ? 0 : goldTable[row + 1][col + 1];  // Gold collected on going to the cell to right down
                 goldTable[row][col] = gold[row][col] + maximum(right, right_up, right_down);             // Max gold collected from taking either of the above 3 paths
            }
        }
        int max = goldTable[0][0];
        for(int[] a : goldTable) {
            max = max(max, a[0]);   // The max amount of gold collected will be the max value in the first column of all rows
        }
        return max;
    }

    public static void main(String[] arg) {
        int[][] gold = {
                         {1, 3, 1, 5},
                         {2, 2, 4, 1},
                         {5, 0, 2, 3},
                         {0, 6, 1, 2}
                       };
        System.out.println(getMaxGold(gold));
    }
}
