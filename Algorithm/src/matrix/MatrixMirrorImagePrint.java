package matrix;

public class MatrixMirrorImagePrint {

    private static void mirrorImage(int[][] a) {
        int R = a.length, C = a[0].length;
        for (int i = 0; i < R; i++) {
            for (int j = 0, k = C - 1; j < C && k >= 0 && j < k; j++, k--) {
                int t = a[i][j];
                a[i][j] = a[i][k];
                a[i][k] = t;
            }
        }
    }

    public static void printMatrix(int[][] a) {
        int R = a.length, C = a[0].length;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printMatrix(a);
        mirrorImage(a);
        printMatrix(a);
    }
}
