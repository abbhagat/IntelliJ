package matrix;

import static util.CommonUtils.printMatrix;

// Time Complexity O(M*N)
public class SpiralMatrixPatternWithOandX {

  private static void printSpiralMatrix(final int ROW, final int COL) {
    char[][] M = new char[ROW][COL];
    char c = 'X';
    int R1 = 0, R2 = ROW - 1;
    int C1 = 0, C2 = COL - 1;
    while (R1 <= R2 && C1 <= C2) {
      for (int i = C1; i <= C2; i++) {
        M[R1][i] = c;
      }
      for (int i = R1 + 1; i <= R2; i++) {
        M[i][C2] = c;
      }
      for (int i = C2 - 1; i >= C1; i--) {
        M[R2][i] = c;
      }
      for (int i = R2 - 1; i >= R1 + 1; i--) {
        M[i][C1] = c;
      }
      R1++;
      R2--;
      C1++;
      C2--;
      c = c == 'X' ? 'O' : 'X';
    }
    printMatrix(M);
  }

  public static void main(String[] args) {
    printSpiralMatrix(5, 5);
    printSpiralMatrix(7, 7);
  }
}
