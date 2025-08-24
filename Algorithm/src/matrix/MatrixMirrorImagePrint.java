package matrix;

import static util.CommonUtils.printMatrix;

public class MatrixMirrorImagePrint {

    private static void mirrorImages(int[][] M) {
        for (int i = 0; i < M.length; i++) {
            for (int j = 0, k = M[i].length - 1; j < k; j++, k--) {
                int t = M[i][j];
                M[i][j] = M[i][k];
                M[i][k] = t;
            }
        }
    }

    private static void mirrorImage(int[][] M) {
        for (int[] a : M) {
            for (int i = 0, j = a.length - 1; i < j; i++, j--) {
                int t = a[i];
                a[i]  = a[j];
                a[j]  = t;
            }
        }
    }

    public static void main(String[] args) {
        int[][] M = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printMatrix(M);
        System.out.println();
        mirrorImage(M);
        printMatrix(M);
        System.out.println();
    }
}
