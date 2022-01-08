package leetcode;

public class AreaOfLargestIslandIn2DMatrix {

    private static int M[][] = new int[][]{
            {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
    };

    private static int ROW = M.length;
    private static int COL = M[0].length;
    private static int area = 0;
    private static boolean[][] visited = new boolean[ROW][COL];

    private static boolean isSafe(int row, int col) {
        return row >= 0 && row < ROW && col >= 0 && col < COL && M[row][col] == 1 && !visited[row][col];
    }

    private static void DFS(int row, int col) {
        int[] rowIdx = {1, -1, 0, 0};
        int[] colIdx = {0, 0, 1, -1};
        visited[row][col] = true;
        for (int k = 0; k < 4; k++) {
            if (isSafe(row + rowIdx[k], col + colIdx[k])) {
                area++;
                DFS(row + rowIdx[k], col + colIdx[k]);
            }
        }
    }

    private static int findMaxArea() {
        int numOfIsland = 0, max_area = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (M[i][j] == 1 && !visited[i][j]) {
                    area = 1;
                    DFS(i, j);
                    System.out.println("Area of Each Island " + area);
                    max_area = Math.max(max_area, area);
                    numOfIsland++;
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
