package cisco;

// Return an array of anti-diagonals of given N*N square matrix
// Time Complexity: O(N*N), Where N is the number of rows or columns of given matrix.
// Auxiliary Space: O(1)

public class AntiDiagonalElements {

    private static void diagonal(int[][] M) {
        int N = M.length;
        // For each column start row is 0
        for (int col = 0; col < N; col++) {
            int startCol = col, startRow = 0;
            while (startCol >= 0 && startRow < N) {
                System.out.print(M[startRow][startCol] + " ");
                startCol--;
                startRow++;
            }
            System.out.println();
        }

        // For each row start column is N-1
        for (int row = 1; row < N; row++) {
            int startRow = row, startCol = N - 1;
            while (startCol >= 0 && startRow < N) {
                System.out.print(M[startRow][startCol] + " ");
                startCol--;
                startRow++;
            }
            System.out.println();
        }
    }

    // Driver code
    public static void main(String[] args) {
        int[][] M = {
                      {1, 2, 3},
                      {4, 5, 6},
                      {7, 8, 9}
                    };
        diagonal(M);
    }
}
