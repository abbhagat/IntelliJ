package matrix;


/*
  11 12 13 14           23 19 15 11     [i][j]   ------ [j][n-i-1]
  15 16 17 18   ---->   24 20 16 12
  19 20 21 22           25 21 17 13
  23 24 25 26           26 22 18 14     [n-j-1][i] --- [n-i-1][n-j-1]
*/

import static matrix.MatrixPrint.printMatrix;

public class MatrixRotationBy90Degree {

    private static void clockWise(int[][] M) {
        int n = M.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int t = M[i][j];
                M[i][j] = M[n - j - 1][i];
                M[n - j - 1][i] = M[n - i - 1][n - j - 1];
                M[n - i - 1][n - j - 1] = M[j][n - i - 1];
                M[j][n - i - 1] = t;
            }
        }
    }

    private static void antiClockWise(int[][] M) {
        int n = M.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int t = M[i][j];
                M[i][j] = M[j][n - i - 1];
                M[j][n - 1 - i] = M[n - i - 1][n - j - 1];
                M[n - i - 1][n - j - 1] = M[n - j - 1][i];
                M[n - j - 1][i] = t;
            }
        }
    }

    public static void main(String[] args) {
        final int[][] M = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("\nOriginal Matrix\n");
        printMatrix(M);
        clockWise(M);
        System.out.println("\nRotated Matrix\n");
        printMatrix(M);
        System.out.println();
        final int[][] n = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("\nOriginal Matrix\n");
        printMatrix(n);
        antiClockWise(n);
        System.out.println("\nRotated Matrix\n");
        printMatrix(n);
    }
}
