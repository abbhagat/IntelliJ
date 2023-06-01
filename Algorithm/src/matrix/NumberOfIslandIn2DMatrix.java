package matrix;

/*
  Input : mat[][] = {{1, 1, 0, 0, 0},
                     {0, 1, 0, 0, 1},
                     {1, 0, 0, 1, 1},
                     {0, 0, 0, 0, 0},
                     {1, 0, 1, 0, 1}
                    }
  Output : 5
  A cell in 2D matrix can be connected to 8 neighbours.So, unlike standard DFS(), where we recursively call for all adjacent vertices,
  here we can recursively call for 8 neighbours only. We keep track of the visited 1s so that they are not visited again.
  Time complexity: O(ROW x COL)
 */
public class NumberOfIslandIn2DMatrix {

    private static final int[][] M = new int[][]{
                                             {1, 1, 0, 0, 0},
                                             {0, 1, 0, 0, 1},
                                             {1, 0, 0, 1, 1},
                                             {0, 0, 0, 0, 0},
                                             {1, 0, 1, 0, 1}
                                          };

    private static final int ROW = M.length;
    private static final int COL = M[0].length;

    private static final boolean[][] visited = new boolean[ROW][COL];
    private static final int[] rowIdx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] colIdx = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
    private static boolean isSafe(int row, int col) {
        return row >= 0 && row < ROW && col >= 0 && col < COL && (M[row][col] == 1 && !visited[row][col]);
    }

    private static void DFS(int row, int col) {
        visited[row][col] = true;
        for (int k = 0; k < 8; k++) {
            if (isSafe(row + rowIdx[k], col + colIdx[k])) {
                   DFS(row + rowIdx[k], col + colIdx[k]);
            }
        }
    }

    private static int countIslands() {
        int count = 0;
        for (int i = 0; i < ROW; i++)
            for (int j = 0; j < COL; j++)
                if (M[i][j] == 1 && !visited[i][j]) {
                    DFS(i, j);
                    count++;
                }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("Number of islands is: " + countIslands());
    }
}
