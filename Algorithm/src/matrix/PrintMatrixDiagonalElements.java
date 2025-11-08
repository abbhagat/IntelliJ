package matrix;

public class PrintMatrixDiagonalElements {

    private static void printLeftDiagonal(int[][] M) {
        int ROW = M.length, COL = M[0].length;
        System.out.print("Left Diagonal Elements : ");
        for (int i = 0, j = 0; i < ROW && j < COL; i++, j++) {
            System.out.print(M[i][j] + " ");
        }
    }

    private static void printRightDiagonal(int[][] M) {
        System.out.print("Right Diagonal Elements : ");
        int ROW = M.length, COL = M[0].length;
        for (int i = 0, j = COL - 1; i < ROW && j >= 0; i++, j--) {
            System.out.print(M[i][j] + " ");
        }
    }

    public static void main(String[] args) {
        int[][] M = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        printLeftDiagonal(M);
        System.out.println();
        printRightDiagonal(M);
    }
}
