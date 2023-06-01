package matrix;

/*
  Given a boolean matrix mat[M][N] of size M X N,
  modify it such that if a matrix cell mat[i][j] is 1 (or true)
  then make all the cells of ith row and jth column as 1.
 */

import static matrix.MatrixPrint.printMatrix;

// Time  Complexity O(M*N)
// Space Complexity O(M*N)
public class BooleanMatrix {

    private static void modifyMatrix(int[][] M) {
        int R = M.length, C = M[0].length;
        int[] row = new int[R];
        int[] col = new int[C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (M[i][j] == 1) {
                    row[i] = col[j] = 1;
                }
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    M[i][j] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] M = {
                        {1, 0, 0, 1},
                        {0, 0, 1, 0},
                        {0, 0, 0, 0}
                      };
        printMatrix(M);
        modifyMatrix(M);
        System.out.println("Result :-");
        printMatrix(M);
    }
}
