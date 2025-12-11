package matrix;

import static util.CommonUtils.printMatrix;

public class ValidateSudoku {

  private static final int[][] board = {
      {5, 3, 4, 6, 7, 8, 9, 1, 2},
      {6, 7, 2, 1, 9, 5, 3, 4, 8},
      {1, 9, 8, 3, 4, 2, 5, 6, 7},
      {8, 5, 9, 7, 6, 1, 4, 2, 3},
      {4, 2, 6, 8, 5, 3, 7, 9, 1},
      {7, 1, 3, 9, 2, 4, 8, 5, 6},
      {9, 6, 1, 5, 3, 7, 2, 8, 4},
      {2, 8, 7, 4, 1, 9, 6, 3, 5},
      {3, 4, 5, 2, 8, 6, 1, 7, 9}
  };

  private static boolean solveSudoku(int[][] board) {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
          for (int c = 1; c <= 9; c++) {
            if (isValid(board, i, j, c)) {
              if (solveSudoku(board)) {
                return true;
              }
            }
          }
          return false;
      }
    }
    return true;
  }

  private static boolean isValid(int[][] board, int row, int col, int c) {
    for (int i = 0; i < 9; i++) {
      if (board[row][i] == c) {
        return false;
      }
      if (board[i][col] == c) {
        return false;
      }
      if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    if (solveSudoku(board)) {
      printMatrix(board);
    } else {
      System.out.println("Invalid Sudoku");
    }
  }
}
