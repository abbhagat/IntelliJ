package matrix;

import static util.CommonUtils.printMatrix;

// Time Complexity O(M*N)
public class SpiralMatrix {

  private static int[][] spiralMatrix(int n) {
    int[][] M = new int[n][n];
    int R1 = 0, C1 = 0, R2 = n - 1, C2 = n - 1, k = n * n;
    while (R1 <= R2 && C1 <= C2) {
      for (int i = C1; i <= C2; i++) {
        M[R1][i] = k--;
      }
      for (int i = R1 + 1; i <= R2; i++) {
        M[i][C2] = k--;
      }
      for (int i = C2 - 1; i >= C1; i--) {
        M[R2][i] = k--;
      }
      for (int i = R2 - 1; i > R1; i--) {
        M[i][C1] = k--;
      }
      R1++;
      R2--;
      C1++;
      C2--;
    }
    return M;
  }

  public static void main(String[] args) {
    System.out.println("The Spiral Matrix is : ");
    printMatrix(spiralMatrix(3));
    printMatrix(spiralMatrix(4));
  }
}
