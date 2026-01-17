package matrix;

public class LargestSquareHaving0InBooleanMatrix {

  private static void findMatrix(int[][] M) {
    int rows = M.length;
    int cols = M[0].length;

    int[][] dp = new int[rows][cols];
    int maxSize = 0;

    // First row
    for (int j = 0; j < cols; j++) {
      if (M[0][j] == 0) {
        dp[0][j] = 1;
        maxSize = 1;
      }
    }

    // First column
    for (int i = 0; i < rows; i++) {
      if (M[i][0] == 0) {
        dp[i][0] = 1;
        maxSize = 1;
      }
    }

    // Fill dp table
    for (int i = 1; i < rows; i++) {
      for (int j = 1; j < cols; j++) {
        if (M[i][j] == 0) {
          dp[i][j] = 1 + Math.min(
              Math.min(dp[i - 1][j], dp[i][j - 1]),
              dp[i - 1][j - 1]
          );
          maxSize = Math.max(maxSize, dp[i][j]);
        }
      }
    }

    System.out.println(maxSize);
  }

  public static void main(String[] args) {
    int[][] M = {
        {0, 1, 1, 0, 1},
        {1, 1, 0, 1, 0},
        {0, 0, 0, 0, 0},
        {1, 0, 0, 0, 0},
        {1, 0, 0, 0, 0},
        {0, 1, 1, 1, 0}
    };
    findMatrix(M);
    int[][] N = {
        {0, 0, 0},
        {0, 0, 0},
        {0, 0, 0},
        {1, 1, 1}
    };
    findMatrix(N);
  }
}
