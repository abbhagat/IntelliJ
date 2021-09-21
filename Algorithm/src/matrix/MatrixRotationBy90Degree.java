package matrix;


/**
 * Input :-
 * 11 12 13 14
 * 15 16 17 18
 * 19 20 21 22
 * 23 24 25 26
 * <p>
 * Output :-
 * 15 11 12 13
 * 19 20 16 14
 * 23 21 17 18
 * 24 25 26 22
 */

public class MatrixRotationBy90Degree {

    private static void rotate(int[][] a) {
        for (int k = 1; k < a.length; k++) {
            int R1 = 0, R2 = a.length - 1;
            int C1 = 0, C2 = a[0].length - 1;

            int prev, curr;

            while (R1 <= R2 && C1 <= C2) {
                prev = a[R1 + 1][C1];
                for (int i = C1; i <= C2; i++) {
                    curr = a[R1][i];
                    a[R1][i] = prev;
                    prev = curr;
                }
                for (int i = R1 + 1; i <= R2; i++) {
                    curr = a[i][C2];
                    a[i][C2] = prev;
                    prev = curr;
                }
                for (int i = C2 - 1; i >= C1; i--) {
                    curr = a[R2][i];
                    a[R2][i] = prev;
                    prev = curr;
                }
                for (int i = R2 - 1; i >= R1; i--) {
                    curr = a[i][C1];
                    a[i][C1] = prev;
                    prev = curr;
                }
                R1++;
                C1++;
                R2--;
                C2--;
            }
        }
    }

    public static void printMatrix(int[][] a) {
        for (int[] x : a) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] a = {{11, 12, 13, 14}, {15, 16, 17, 18}, {19, 20, 21, 22}, {23, 24, 25, 26}};
        printMatrix(a);
        rotate(a);
        System.out.println("Rotated Matrix");
        printMatrix(a);
    }
}
