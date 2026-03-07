package matrix;

import static util.CommonUtils.swap;

public class TransposeMatrix {

  public static int[][] transposeNonSquare(int[][] M) {
    int R = M.length, C = M[0].length;
    int[][] TM = new int[C][R];
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        TM[j][i] = M[i][j];
      }
    }
    return TM;
  }

  public static void findTranspose(int[][] M) {
    int R = M.length, C = M[0].length;
    for (int i = 0; i < R; i++) {
      for (int j = i; j < C; j++) {
        swap(M, i, j);
      }
    }
  }

}
