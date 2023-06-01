package matrix;

public class MatrixPrint {

    public static void printMatrix(int[][] M) {
        for (int[] x : M) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }

    public static void printMatrix(char[][] M) {
        for (char[] x : M) {
            for (char y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }
}
