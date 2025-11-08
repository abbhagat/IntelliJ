package matrix;

public class MatrixMirrorImage {

    private static boolean isMirrorImage(int[][] a, int[][] b) {
        int R1 = a.length, C1 = a[0].length;
        int R2 = b.length, C2 = b[0].length;
        if (R1 == R2 && C1 == C2) {
            for (int k = 0; k < R1; k++) {
                for (int i = 0, j = C1 - 1; i < j; i++, j--) {
                    if (a[k][i] != b[k][j]) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] b = {{3, 2, 1}, {6, 5, 4}, {9, 8, 7}};
        System.out.println(isMirrorImage(a, b));
        int[][] c = {{3, 2, 1}, {4, 5, 6}, {9, 8, 7}};
        System.out.println(isMirrorImage(a, c));
    }
}
