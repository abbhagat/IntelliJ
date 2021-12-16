package matrix;

// Time Complexity O(M*N)
public class NQueenProblem {

    private static final int N = 4;

/* A utility function to check if a queen can be placed on board[row][col].
   Note that this function is called when "col" queens are already placed
   in columns from 0 to col -1. So we need to check only left side for attacking queens.
*/

    private static boolean isSafe(int board[][], int row, int col) {
        for (int i = 0; i < col; i++) {  // Check this row on left side
            if (board[row][i] == 1) {
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {  // Check upper diagonal on left side
            if (board[i][j] == 1) {
                return false;
            }
        }
        for (int i = row, j = col; j >= 0 && i < N; i++, j--) {  // Check lower diagonal on left side
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean solveNQUtil(int board[][], int col) {  // A recursive utility function to solve N Queen problem
        if (col >= N) {                                          // base case: If all queens are placed then return true
            return true;
        }
        for (int i = 0; i < N; i++) {                            // Consider this column and try placing this queen in all rows one by one
            if (isSafe(board, i, col)) {                        // Check if the queen can be placed on board[i][col]
                board[i][col] = 1;                             // Place this queen in board[i][col]
                if (solveNQUtil(board, col + 1)) {        // recur to place rest of the queens
                    return true;
                }
                board[i][col] = 0; // If placing queen in board[i][col] doesn't lead to a solution then remove queen from board[i][col]  BACKTRACK
            }
        }
        return false;  // If the queen can not be placed in any row in this column col, then return false
    }

    /* This function solves the N Queen problem using Backtracking.
       It mainly uses solveNQUtil () to solve the problem.
       It returns false if queens cannot be placed, otherwise, return true and prints placement of queens in the form of 1s.
       Please note that there may be more than one solutions, this function prints one of the feasible solutions. */

    public static void main(String args[]) {
        int board[][] = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        if (solveNQUtil(board, 0)) {
            for (int[] a : board) {
                for (int x : a) {
                    System.out.print(" " + x + " ");
                }
                System.out.println();
            }
        }
    }
}
