package matrix;

import static matrix.TransposeMatrix.findTranspose;
import static util.CommonUtils.printMatrix;
import static util.CommonUtils.swap;

public class MatrixRotationBy90Degree {

  public static void rotateBy90ClockwiseForSquareMatrix(int[][] M) {
    findTranspose(M);
    for (int[] a : M) {                // Reverse Each ROW
      int i = 0, j = M[0].length - 1;
      while (i < j) {
        swap(a, i, j);
        i++;
        j--;
      }
    }
    printMatrix(M);
  }

  public static void rotate90AntiClockwiseForSquareMatrix(int[][] M) {
    findTranspose(M);
    final int ROW = M.length, COL = M[0].length;
    for (int i = 0; i < ROW; i++) {
      // Reverse Each Column
      int j = 0, k = COL - 1;
      while ( j < k) {
        int t   = M[j][i];
        M[j][i] = M[k][i];
        M[k][i] = t;
        j++;
        k--;
      }
    }
    printMatrix(M);
  }

  public static void rotateBy90ClockwiseForNonSquareMatrix(int[][] M) {
    int R = M.length;
    int C = M[0].length;
    int[][] RM = new int[C][R];
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        RM[j][R - 1 - i] = M[i][j];
      }
    }
    printMatrix(RM);
  }

  public static void rotateBy90AntiClockwiseForNonSquareMatrix(int[][] M) {
    int R = M.length;
    int C = M[0].length;
    int[][] RM = new int[C][R];
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        RM[C - 1 - j][i] = M[i][j];
      }
    }
    printMatrix(RM);
  }

  public static void main(String[] args) {
    final int[][] M = {
                          {1, 2, 3},
                          {4, 5, 6},
                          {7, 8, 9}
                      };
    rotateBy90ClockwiseForSquareMatrix(M);
    final int[][] N = {
                          {1, 2, 3},
                          {4, 5, 6},
                          {7, 8, 9}
                      };
    rotateBy90ClockwiseForNonSquareMatrix(N);
  }
}
