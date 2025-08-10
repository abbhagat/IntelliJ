package matrix;

import static util.CommonUtils.printMatrix;
import static util.CommonUtils.swap;

public class MatrixRotationBy90Degree {

    private static void findTranspose(int[][] M) {
        final int ROW = M.length, COL = M[0].length;
        for (int i = 0; i < ROW; i++) {
            for (int j = i; j < COL; j++) {
                swap(M, i, j);
            }
        }
    }

    public static void rotate90Clockwise(int[][] M) {
        findTranspose(M);
        final int ROW = M.length, COL = M[0].length;
        // Reverse each row
        for (int[] a : M) {
            for (int i = 0, j = COL - 1; i < j; i++, j--) {
                swap(a, i, j);
            }
        }
        printMatrix(M);
    }

    public static void rotate90AntiClockwise(int[][] M) {
        findTranspose(M);
        final int ROW = M.length, COL = M[0].length;
        for (int i = 0; i < ROW; i++) {               // Reverse Each Column
            for (int j = 0, k = COL - 1; j < k; j++, k--) {
                int t = M[j][i];
                M[j][i] = M[k][i];
                M[k][i] = t;
            }
        }
        printMatrix(M);
    }

    public static void main(String[] args) {
        final int[][] M = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotate90Clockwise(M);
        rotate90AntiClockwise(M);
    }
}
