package matrix;

/**
 * Given a boolean matrix mat[M][N] of size M X N, modify it such that if a matrix cell mat[i][j] is 1 (or true)
 * then make all the cells of ith row and jth column as 1.
 */
public class BooleanMatrix {

    private static void modifyMatrix(int[][] M, int R, int C) {
        int[] row = new int[R];
        int[] col = new int[C];
        int i, j;

        for (i = 0; i < R; i++) {
            for (j = 0; j < C; j++) {
                if (M[i][j] == 1) {
                    row[i] = col[j] = 1;
                }
            }
        }

        for (i = 0; i < R; i++) {
            for (j = 0; j < C; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    M[i][j] = 1;
                }
            }
        }
    }

    public static void printMatrix(int mat[][], int R, int C) {
        int i, j;
        for (i = 0; i < R; i++) {
            for (j = 0; j < C; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int mat[][] = {{1, 0, 0, 1},
                       {0, 0, 1, 0},
                       {0, 0, 0, 0}
                      };
        System.out.println("Matrix Initially");
        printMatrix(mat, 3, 4);
        modifyMatrix(mat, 3, 4);
        System.out.println("Matrix after modification");
        printMatrix(mat, 3, 4);
    }
}
