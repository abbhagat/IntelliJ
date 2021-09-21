package matrix;

/**
 * Input : mat[][] = {{1, 1, 0, 0, 0},
 * {0, 1, 0, 0, 1},
 * {1, 0, 0, 1, 1},
 * {0, 0, 0, 0, 0},
 * {1, 0, 1, 0, 1}
 * Output : 5
 * <p>
 * A cell in 2D matrix can be connected to 8 neighbours.
 * So, unlike standard DFS(), where we recursively call for all adjacent vertices,
 * here we can recursively call for 8 neighbours only.
 * We keep track of the visited 1s so that they are not visited again.
 * <p>
 * Time complexity: O(ROW x COL)
 */
public class NumberOfIslandIn2DMatrix {

    private static int M[][] = new int[][]{
            {1, 1, 0, 0, 0},
            {0, 1, 0, 0, 1},
            {1, 0, 0, 1, 1},
            {0, 0, 0, 0, 0},
            {1, 0, 1, 0, 1}
    };

    private static final int ROW = M.length;
    private static final int COL = M[0].length;

    private static boolean visited[][] = new boolean[ROW][COL]; // Make a bool array to mark visited cells. Initially all cells are unvisited

    // A function to check if a given cell (row, col) can be included in DFS
    // row number is in range, column number is in range and value is 1 and not yet visited
    private static boolean isSafe(int row, int col) {
        return row >= 0 && row < ROW && col >= 0 && col < COL && (M[row][col] == 1 && !visited[row][col]);
    }

    // A utility function to do DFS for a 2D boolean matrix. It only considers the 8 neighbours as adjacent vertices
    private static void DFS(int row, int col) {
        // These arrays are used to get row and column numbers of 8 neighbours of a given cell
        int rowNbr[] = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int colNbr[] = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
        visited[row][col] = true;  // Mark this cell as visited
        // Recur for all connected neighbours
        for (int k = 0; k < 8; k++) {
            if (isSafe(row + rowNbr[k], col + colNbr[k])) {
                DFS(row + rowNbr[k], col + colNbr[k]);
            }
        }
    }

    private static int countIslands() {
        // Initialize count as 0 and traverse through the all cells of given matrix
        int count = 0;
        for (int i = 0; i < ROW; i++)
            for (int j = 0; j < COL; j++)
                if (M[i][j] == 1 && !visited[i][j]) {
                    // If a cell with value 1 is not visited yet, then new island found, Visit all  cells in this island and increment island count
                    DFS(i, j);
                    count++;
                }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("Number of islands is: " + countIslands());
    }
}
