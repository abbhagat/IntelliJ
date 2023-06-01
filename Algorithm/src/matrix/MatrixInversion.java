package matrix;

import static matrix.MatrixPrint.printMatrix;

public class MatrixInversion {
    private static int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

    private static void matrixInversion() {
        int j = 2;
        for (int i = 0; i < 3; i++) {
            if (i == 0 || i == 2) {
                int t = a[i][j];
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
