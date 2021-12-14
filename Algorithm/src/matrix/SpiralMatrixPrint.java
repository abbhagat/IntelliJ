package matrix;

public class SpiralMatrixPrint {

    public static void main(String[] args) {
        int[][] M = new int[][]{
                {1, 2, 3, 4},
                {0, 1, 1, 5},
                {9, 8, 7, 6},
                {4, 5, 9, 10}
        };
        int R1 = 0, R2 = M.length - 1;
        int C1 = 0, C2 = M[0].length - 1;
        int k = 1;
        int N = M.length * M[0].length;
        while (R1 <= R2 && C1 <= C2) {
            for (int i = C1; i <= C2 && k <= N; i++) {
                System.out.print(M[R1][i]);
                k++;
            }
            for (int i = R1 + 1; i <= R2 && k <= N; i++) {
                System.out.print(M[i][C2]);
                k++;
            }
            for (int i = C2 - 1; i >= C1 && k <= N; i--) {
                System.out.print(M[R2][i]);
                k++;
            }
            for (int i = R2 - 1; i > R1 && k <= N; i--) {
                System.out.print(M[i][C1]);
                k++;
            }
            R1++;
            R2--;
            C1++;
            C2--;
        }
    }
}