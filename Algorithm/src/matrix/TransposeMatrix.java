package matrix;

import static util.CommonUtils.swap;

public class TransposeMatrix {

  public static int[][] transposeNonSquare(int[][] M) {
    int rows = M.length;
    int cols = M[0].length;
    int[][] TM = new int[cols][rows];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        TM[j][i] = M[i][j];
      }
    }
    return TM;
  }

  public static void findTranspose(int[][] M) {
    final int m = M.length, n = M[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = i; j < n; j++) {
        swap(M, i, j);
      }
    }
  }

}
