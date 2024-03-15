package matrix;

public class PrintMatrixDiagonalElements {

    public static void main(String[] args) {
        int[][] M = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int i = 0;
        for (int j = 0; j < M[0].length; j++, i++) {
            if (i == j) {
                System.out.println(M[i][j]);
            }
        }
        i = 0;
        for (int j = M[0].length - 1; j >= 0; j--, i++) {
            if (i + j == M.length - 1) {
                System.out.println(M[i][j]);
            }
        }
    }
}
