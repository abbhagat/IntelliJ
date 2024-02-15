package matrix;

import static util.CommonUtils.printMatrix;


/*
Time Complexity: O(M*N*P) for the traversal of the nested loops.
In case, of the specific example with multiplication of 4×3 matrix and 3×4 matrix, M=P,
that's why the time complexity becomes = O(M2*N).

Auxiliary Space: O(M*N), as we are using extra space.
 */
public class MatrixMultiplication {

    private static int[][] matrixMultiply(int[][] a, int[][] b) {
        int R1 = a.length, C1 = a[0].length;
        int R2 = b.length, C2 = b[0].length;
        if (C1 == R2) {
            int[][] M = new int[R1][C2];
            for (int i = 0; i < R1; i++) {
                for (int j = 0; j < C2; j++) {
                    M[i][j] = 0;
                    for (int k = 0; k < R2; k++) {
                        M[i][j] += a[i][k] * b[k][j];
                    }
                }
            }
            return M;
        }
        return null;
    }

    public static void main(String[] args) {
        int[][] a = {
                      {1, 1, 1},
                      {2, 2, 2},
                      {3, 3, 3},
                      {4, 4, 4}
                    };

        int[][] b = {
                      {1, 1, 1, 1},
                      {2, 2, 2, 2},
                      {3, 3, 3, 3}
                    };
        int[][] M = matrixMultiply(a,b);
        printMatrix(M);
    }
}
