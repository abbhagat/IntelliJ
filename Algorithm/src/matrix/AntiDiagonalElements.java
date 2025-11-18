package matrix;

// Return an array of anti-diagonals of given n*n square matrix
// Time Complexity: O(n*n), Where n is the number of rows or columns of given matrix.
// Auxiliary Space: O(1)

public class AntiDiagonalElements {

  private static void rightDiagonal(int[][] M) {
    int n = M.length;
    for (int col = 0; col < n; col++) {             // For each column start row is 0
      int i = 0, j = col;
      while (j >= 0 && i < n) {
        System.out.print(M[i][j] + " ");
        i++;
        j--;
      }
      System.out.println();
    }
    for (int row = 1; row < n; row++) {          // For each row start column is n-1
      int i = row, j = n - 1;
      while (j >= 0 && i < n) {
        System.out.print(M[i][j] + " ");
        i++;
        j--;
      }
      System.out.println();
    }
  }

  private static void leftDiagonal(int[][] M) {
    int n = M.length;
    for (int col = n - 1; col >= 0; col--) {             // For each column start row is 0
      int i = 0, j = col;
      while (j >= 0 && i < n) {
        System.out.print(M[i][j] + " ");
        i++;
        j--;
      }
      System.out.println();
    }
    for (int row = 1; row < n; row++) {                  // For each row start column is n-1
      int i = row, j = 0;
      while (j < n && i < n) {
        System.out.print(M[i][j] + " ");
        i++;
        j++;
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    int[][] M = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    System.out.println("Right Diagonal");
    rightDiagonal(M);
    System.out.println("Left Diagonal");
    leftDiagonal(M);
  }
}
