package matrix;

import static java.lang.Integer.min;

// Time Complexity O(M*N)
public class LargestSquareHaving1InBooleanMatrix {

    private static void findMatrix(int[][] M) {
        int R = M.length, C = M[0].length;
        int[][] S = new int[R][C];
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                S[i][j] = M[i][j] == 1 ? min(S[i][j - 1], min(S[i - 1][j], S[i - 1][j - 1])) + 1 : 0;
            }
        }
        int max = S[0][0], row = 0, col = 0;
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (max < S[i][j]) {
                    max = S[i][j];
                    row = i;
                    col = j;
                }
            }
        }
        for (int i = row; i > row - max; i--) {
            for (int j = col; j > col - max; j--) {
                System.out.print(M[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int M[][] = {{0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}
        };
        findMatrix(M);
    }
}
