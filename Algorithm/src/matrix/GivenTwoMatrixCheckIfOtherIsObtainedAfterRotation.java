package matrix;

/*
  11 12 13 14           23 19 15 11     [i][j]   ------ [j][n-i-1]
  15 16 17 18   ---->   24 20 16 12
  19 20 21 22           25 21 17 13
  23 24 25 26           26 22 18 14     [n-j-1][i] --- [n-i-1][n-j-1]
*/
public class GivenTwoMatrixCheckIfOtherIsObtainedAfterRotation {

  private static boolean checkRotation(int[][] a, int[][] b) {
    int n = a.length;
    int c0 = 0, c90 = 0, c180 = 0, c270 = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (b[i][j] == a[n - j - 1][i]) {
          c90++;
        }
        if (b[i][j] == a[n - i - 1][n - j - 1]) {
          c180++;
        }
        if (b[i][j] == a[j][n - i - 1]) {
          c270++;
        }
        if (b[i][j] == a[i][j]) {
          c0++;
        }
      }
    }
    return c90 == n * n || c270 == n * n || c180 == n * n || c0 == n * n;
  }

  public static void main(String[] args) {
    int[][] a = {
        {0, 0, 0},
        {0, 1, 0},
        {1, 1, 1}
    };
    int[][] b = {
        {1, 1, 1},
        {0, 1, 0},
        {0, 0, 0}
    };
    System.out.println(checkRotation(a, b));
  }
}
