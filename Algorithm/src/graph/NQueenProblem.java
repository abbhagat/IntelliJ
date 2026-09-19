package graph;

import static util.CommonUtils.printMatrix;

// Time Complexity O(M*N)
public class NQueenProblem {

  private static boolean isSafe(int[][] board, int row, int col) {
    for (int i = 0; i < col; i++) {
      if (board[row][i] == 1) {
        return false;
      }
    }
    for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
      if (board[i][j] == 1) {
        return false;
      }
    }
    for (int i = row, j = col; i < board.length && j >= 0; i++, j--) {
      if (board[i][j] == 1) {
        return false;
      }
    }
    return true;
  }

  private static boolean solveNQUtil(int[][] board, int col) {
    if (col >= board.length) {
      return true;
    }
    for (int row = 0; row < board.length; row++) {
      if (isSafe(board, row, col)) {
        board[row][col] = 1;
        if (solveNQUtil(board, col + 1)) {
          return true;
        }
        board[row][col] = 0;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int[][] board = new int[4][4];
    if (solveNQUtil(board, 0)) {
      printMatrix(board);
    } else {
      System.out.println("No Solution Exist");
    }
  }
}
