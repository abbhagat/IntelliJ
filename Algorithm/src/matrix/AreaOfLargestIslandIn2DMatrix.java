package matrix;

import static java.lang.Integer.max;

// Time Complexity: O(ROW * COL)

public class AreaOfLargestIslandIn2DMatrix {

    private static final int[][] M = new int[][]{
            {1, 1, 0, 0, 0},
            {1, 1, 0, 1, 1},
            {1, 0, 1, 1, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1}
    };

    private static final int ROW = M.length;
    private static final int COL = M[0].length;
    private static int area = 1;
    private static final boolean[][] visited = new boolean[ROW][COL];

    private static final int[] rowIdx = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] colIdx = {-1, 0, 1, -1, 1, -1, 0, 1};

    private static boolean isSafe(int row, int col) {
        return row >= 0 && row < ROW && col >= 0 && col < COL && M[row][col] == 1 && !visited[row][col];
    }

    private static void dfs(int row, int col) {
        visited[row][col] = true;
        for (int k = 0; k < 8; k++) {
            if (isSafe(row + rowIdx[k], col + colIdx[k])) {
                area++;
                dfs(row + rowIdx[k], col + colIdx[k]);
            }
        }
    }

    private static int[] getNumOfIsland() {
        int maxArea = 0, numOfIsland = 0;
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                if (M[row][col] == 1 && !visited[row][col]) {
                    area = 1;
                    dfs(row, col);
                    System.out.println("Area of Each Island " + area);
                    numOfIsland++;
                    maxArea = max(maxArea, area);
                }
            }
        }
        return new int[]{numOfIsland, maxArea};
    }

    public static void main(String[] args) {
        int[] result = getNumOfIsland();
        System.out.println("Number of islands is: " + result[0]);
        System.out.println("Max Area " + result[1]);
    }
}
