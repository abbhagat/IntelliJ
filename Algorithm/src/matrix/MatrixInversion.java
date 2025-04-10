package matrix;

import static util.CommonUtils.printMatrix;

public class MatrixInversion {

    private static final int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

    private static void matrixInversion() {
        int j = 2, n = a.length;
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n - 1) {
                int t   = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = t;
            }
        }
    }

    public static void main(String[] args) {
        printMatrix(a);
        matrixInversion();
        System.out.println();
        printMatrix(a);
    }
}
