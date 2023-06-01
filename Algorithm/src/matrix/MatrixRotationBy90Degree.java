package matrix;


/*
  11 12 13 14           23 19 15 11     [0][0]   ------ [j][n-i-1]
  15 16 17 18   ---->   24 20 16 12
  19 20 21 22           25 21 17 13
  23 24 25 26           26 22 18 14     [n-j-1][i] --- [n-i-1][n-j-1]
*/

import static matrix.MatrixPrint.printMatrix;

public class MatrixRotationBy90Degree {

    private static void rotate(int[][] M) {
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

    public static void main(String[] args) {
        int[][] M = {
                {11, 12, 13, 14},
                {15, 16, 17, 18},
                {19, 20, 21, 22},
                {23, 24, 25, 26}
        };
        printMatrix(M);
        rotate(M);
        System.out.println("Rotated Matrix");
        printMatrix(M);
    }
}
