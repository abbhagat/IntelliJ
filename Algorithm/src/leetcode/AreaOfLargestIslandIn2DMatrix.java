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

    private static int DFS(int row, int col) {
        int[] rowIdx = {1, -1, 0, 0};
        int[] colIdx = {0, 0, 1, -1};
        visited[row][col] = true;
        for (int k = 0; k < 4; k++) {
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
