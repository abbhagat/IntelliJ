package matrix;

import static java.lang.Integer.max;

/*

Time complexity: O(ROW * COL).
At worst case all the cells will be visited so time complexity is O(ROW * COL).
Auxiliary Space:O(ROW * COL).
To store the visited nodes O(ROW * COL) space is needed

Consider a matrix with rows and columns, where each cell contains either a ‘0’ or a ‘1’ and any cell containing a 1 is called a filled cell.
Two cells are said to be connected if they are adjacent to each other horizontally, vertically, or diagonally.
If one or more filled cells are also connected, they form a region. find the length of the largest region.

Examples:

Input : M[][5] = { 0 0 1 1 0
                   1 0 1 1 0
                   0 1 0 0 0
                   0 0 0 0 1 }
Output : 6
In the following example, there are 2 regions one with length 1 and the other as 6. So the largest region: 6

Input : M[][5] = { 0 0 1 1 0
                   0 0 1 1 0
                   0 0 0 0 0
                   0 0 0 0 1 }
Output: 4
In the following example, there are 2 regions one with length 1 and the other as 4. So the largest region: 4
 */
public class AreaOfLargestIslandIn2DMatrix {

    private static final int[][] M = new int[][]{
                                            {1, 1, 0, 0, 0},
                                            {1, 1, 0, 1, 1},
                                            {1, 0, 0, 1, 1},
                                            {1, 0, 1, 0, 1},
                                            {1, 0, 1, 0, 1}
                                          };

    private static final int ROW = M.length;
    private static final int COL = M[0].length;
    private static int area = 0;
    private static final boolean[][] visited = new boolean[ROW][COL];

    private static final int[] rowIdx = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] colIdx = {-1, 0, 1, -1, 1, -1, 0, 1};
    private static boolean isSafe(int row, int col) {
        return row >= 0 && row < ROW && col >= 0 && col < COL && M[row][col] == 1 && !visited[row][col];
    }

    private static void DFS(int row, int col) {
        visited[row][col] = true;
        for (int k = 0; k < 8; k++) {
            if (isSafe(row + rowIdx[k], col + colIdx[k])) {
                area++;
                DFS(row + rowIdx[k], col + colIdx[k]);
            }
        }
    }

    private static int findMaxArea() {
        int max_area = 0, numOfIsland = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (M[i][j] == 1 && !visited[i][j]) {
                    area = 1;
                    DFS(i, j);
                    System.out.println("Area of Each Island " + area);
                    numOfIsland++;
                    max_area = max(max_area, area);
                }
            }
        }
        System.out.println("Number of islands is: " + numOfIsland);
        return max_area;
    }

    public static void main(String[] args) {
        System.out.println("Max Area " + findMaxArea());
    }
}
