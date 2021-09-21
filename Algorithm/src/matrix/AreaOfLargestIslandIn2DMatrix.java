package matrix;

/*

Consider a matrix with rows and columns, where each cell contains either a ‘0’ or a ‘1’ and any cell containing a 1 is called a filled cell. Two cells are said to be connected if they are adjacent to each other horizontally, vertically, or diagonally. If one or more filled cells are also connected, they form a region. find the length of the largest region.

Examples:

Input : M[][5] = { 0 0 1 1 0
                   1 0 1 1 0
                   0 1 0 0 0
                   0 0 0 0 1 }
Output : 6
In the following example, there are
2 regions one with length 1 and the
other as 6. So largest region: 6

Input : M[][5] = { 0 0 1 1 0
                   0 0 1 1 0
                   0 0 0 0 0
                   0 0 0 0 1 }
Output: 4
In the following example, there are
2 regions one with length 1 and the
other as 4. So largest region: 4
 */
public class AreaOfLargestIslandIn2DMatrix {

    private static int M[][] = new int[][]{
            {1, 1, 0, 0, 0},
            {1, 1, 0, 1, 1},
            {1, 0, 0, 1, 1},
            {0, 0, 0, 0, 0},
            {1, 0, 1, 0, 1}
    };

    private static int ROW = M.length;
    private static int COL = M[0].length;
    private static int area = 0;
    private static boolean[][] visited = new boolean[ROW][COL];


    private static boolean isSafe(int row, int col) {
        return row >= 0 && row < ROW && col >= 0 && col < COL && M[row][col] == 1 && !visited[row][col];
    }

    private static int DFS(int row, int col) {
        int[] rowIdx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colIdx = {-1, 0, 1, -1, 1, -1, 0, 1};
        visited[row][col] = true;
        for (int k = 0; k < 8; k++) {
            if (isSafe(row + rowIdx[k], col + colIdx[k])) {
                area++;
                DFS(row + rowIdx[k], col + colIdx[k]);
            }
        }
        return area;
    }

    private static int findMaxArea() {
        int max_area = 0;
        int count = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (M[i][j] == 1 && !visited[i][j]) {
                    area = 1;
                    System.out.println("Area of Each Island " + DFS(i, j));
                    count++;
                    max_area = Math.max(max_area, area);
                }
            }
        }
        System.out.println("Number of islands is: " + count);
        return max_area;
    }

    public static void main(String[] args) {
        System.out.println("Max Area " + findMaxArea());
    }
}
