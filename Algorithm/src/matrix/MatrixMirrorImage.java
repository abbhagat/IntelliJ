package matrix;

public class MatrixMirrorImage {

    private static boolean isMirrorImage(int[][] a, int[][] b) {
        int R = a.length, C = a[0].length;
        for (int i = 0; i < R; i++) {
            for (int j = 0, k = C - 1; j < C && k >= 0; j++, k--) {
                if (a[i][j] != b[i][k]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] b = {{3, 2, 1}, {6, 5, 4}, {9, 8, 7}};
        System.out.println(isMirrorImage(a, b));
        int[][] c = {{1, 2, 3}, {5, 4, 1}, {6, 7, 2}};
        int[][] d = {{3, 2, 1}, {5, 4, 1}, {2, 7, 6}};
        System.out.println(isMirrorImage(c, d));
    }
}
