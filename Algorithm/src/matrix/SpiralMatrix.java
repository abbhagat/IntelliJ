package matrix;

// Time Complexity O(M*N)

import static matrix.MatrixPrint.printMatrix;

public class SpiralMatrix {

    public static void main(String[] args) {
        final int n = 4;
        int[][] M = new int[n][n];
        int R1, R2, C1, C2, k = n * n;
        R1 = C1 = 0;
        R2 = C2 = M[0].length - 1;
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
            for (int i = R2 - 1; i >= R1 + 1; i--) {
                M[i][C1] = k--;
            }
            R1++;
            R2--;
            C1++;
            C2--;
        }
        System.out.println("The Spiral Matrix is : ");
        printMatrix(M);
    }
}
