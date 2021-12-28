package matrix;


/*
  11 12 13 14           23 19 15 11
  15 16 17 18   ---->   24 20 16 12
  19 20 21 22           25 21 17 13
  23 24 25 26           26 22 18 14
*/

public class MatrixRotationBy90Degrees {

    private static void rotate(int[][] a) {
        int n = a.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int t = a[i][j];
                a[i][j] = a[n - j - 1][i];
                a[n - j - 1][i] = a[n - i - 1][n - j - 1];
                a[n - i - 1][n - j - 1] = a[j][n - i - 1];
                a[j][n - i - 1] = t;
            }
        }
    }

    public static void printMatrix(int[][] M) {
        for (int[] x : M) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] M = {{11, 12, 13, 14}, {15, 16, 17, 18}, {19, 20, 21, 22}, {23, 24, 25, 26}};
        printMatrix(M);
        rotate(M);
        System.out.println("Rotated Matrix");
        printMatrix(M);
    }
}
