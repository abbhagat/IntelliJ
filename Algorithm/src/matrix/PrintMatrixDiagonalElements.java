package matrix;

public class PrintMatrixDiagonalElements {

    public static void main(String[] args) {
        int[][] M = {
                      {1, 2, 3},
                      {4, 5, 6},
                      {7, 8, 9}
                    };
        int ROW = M.length, COL = M[0].length;
        for (int i = 0, j = 0; i < ROW && j < COL; i++, j++) {
            System.out.println(M[i][j]);
        }
        for (int i = 0, j = COL - 1; i < ROW && j >= 0; i++, j--) {
            System.out.println(M[i][j]);
        }
    }
}
