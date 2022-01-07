package matrix;

// Time Complexity O(M*N)
public class NQueenProblem {

    private static int[][] board = {
                                     {0, 0, 0, 0},
                                     {0, 0, 0, 0},
                                     {0, 0, 0, 0},
                                     {0, 0, 0, 0}
                                   };
    private static final int N = board.length;

    private static boolean isSafe(int row, int col) {
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        for (int i = row, j = col; j >= 0 && i < N; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean solveNQUtil(int col) {
        if (col >= N) {
            return true;
        }
        for (int i = 0; i < N; i++) {
            if (isSafe(i, col)) {
                board[i][col] = 1;
                if (solveNQUtil(col + 1)) {
                    return true;
                }
                board[i][col] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        if (solveNQUtil(0)) {
            for (int[] a : board) {
                for (int x : a) {
                    System.out.print(" " + x + " ");
                }
                System.out.println();
            }
        }
    }
}
