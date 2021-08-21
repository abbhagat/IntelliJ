package matrix;

public class Sudoku {

    private int[][] a = {
            {3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0}
    };

    private int row, col;

    private boolean solveSudoku() {
        if (!findUnassignedLocation()) {
            return true; // success!
        }
        for (int num = 1; num <= 9; num++) {
            if (isSafe(row, col, num)) {
                a[row][col] = num; // make tentative assignment
                if (solveSudoku()) {
                    return true; // return, if success
                }
                a[row][col] = 0; // failure, unmake & try again
            }
        }
        return false;
    }

    private boolean findUnassignedLocation() {
        for (row = 0; row < a.length; row++) {
            for (col = 0; col < a[0].length; col++) {
                if (a[row][col] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean isSafe(int row, int col, int num) {
        /*
         * Check if 'num' is not already placed in current row,current column and current 3x3 box
         */
        return !usedInRow(row, num) && !usedInCol(col, num) && !usedInBox(row - row % 3, col - col % 3, num);
    }

    /*
     * Returns a boolean which indicates whether any assigned entry in the specified row matches the given number.
     */

    boolean usedInRow(int row, int num) {
        for (int i = 0; i < a[0].length; i++) {
            if (a[row][i] == num) {
                return true;
            }
        }
        return false;
    }

    /*
     * Returns a boolean which indicates whether any assigned entry in the
     * specified column matches the given number.
     */

    boolean usedInCol(int col, int num) {
        for (int i = 0; i < a[0].length; i++) {
            if (a[i][col] == num) {
                return true;
            }
        }
        return false;
    }

    /*
     * Returns a boolean which indicates whether any assigned entry within the
     * specified 3x3 box matches the given number.
     */

    boolean usedInBox(int boxStartRow, int boxStartCol, int num) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (a[i + boxStartRow][j + boxStartCol] == num) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Sudoku s = new Sudoku();
        if (s.solveSudoku()) {
            for (int[] x : s.a) {
                for (int y : x) {
                    System.out.print(y + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("No solution exists");
        }
    }
}
