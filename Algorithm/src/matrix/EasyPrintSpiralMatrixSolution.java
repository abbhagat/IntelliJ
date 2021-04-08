package matrix;

public class EasyPrintSpiralMatrixSolution {

    public static void main(String[] args) {
        final int n = 4;
        int[][] A = new int[n][n];
        int k = n * n;
        int C1 = 0, C2 = A[0].length - 1;
        int R1 = 0, R2 = A[0].length - 1;

        while (R1 <= R2 && C1 <= C2) {
            for (int i = C1; i <= C2; i++) {
                A[R1][i] = k--;
            }

            for (int i = R1 + 1; i <= R2; i++) {
                A[i][C2] = k--;
            }

            for (int i = C2 - 1; i >= C1; i--) {
                A[R2][i] = k--;
            }

            for (int i = R2 - 1; i >= R1 + 1; i--) {
                A[i][C1] = k--;
            }
            R1++;
            R2--;
            C1++;
            C2--;
        }

        System.out.println("The Spiral Matrix is:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(A[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
