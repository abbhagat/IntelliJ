package matrix;

public class PrintMatrixDiagonalElements {

    public static void main(String[] args) {
        int[][] M = {
                {1, 2, 3},
                {4, 5, 6}
        };
        int ROW = M.length, COL = M[0].length;
        for (int i = 0, j = 0; i < ROW && j < COL; j++, i++) {
            System.out.println(M[i][j]);
        }
        for (int i = 0, j = COL - 1; j >= 0 && i < ROW; j--, i++) {
            if (i + j == COL - 1) {
                System.out.println(M[i][j]);
            }
        }
    }
}
