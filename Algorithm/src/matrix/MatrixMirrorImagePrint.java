package matrix;

import static matrix.MatrixPrint.printMatrix;

public class MatrixMirrorImagePrint {

    private static void mirrorImage(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0, k = a[0].length - 1; j < k; j++, k--) {
                int t = a[i][j];
                a[i][j] = a[i][k];
                a[i][k] = t;
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printMatrix(a);
        mirrorImage(a);
        printMatrix(a);
    }
}
