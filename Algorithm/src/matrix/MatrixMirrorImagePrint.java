package matrix;

import static util.CommonUtils.printMatrix;
import static util.CommonUtils.swap;

public class MatrixMirrorImagePrint {


    private static void mirrorImages(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0, k = a[i].length - 1; j < k; j++, k--) {
                int t = a[i][j];
                a[i][j] = a[i][k];
                a[i][k] = t;
            }
        }
    }

    private static void mirrorImage(int[][] a) {
        for (int[] m : a) {
            for (int i = 0, j = m.length - 1; i < j; i++, j--) {
                swap(m, i, j);
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printMatrix(a);
        System.out.println();
        mirrorImage(a);
        printMatrix(a);
        System.out.println();
    }
}
