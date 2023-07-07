package matrix;

import static java.lang.Integer.max;

public class BombEnemy {
    private static final char[][] M = new char[][]{
                                                    {'O', 'E', 'O', 'O'},
                                                    {'E', 'O', 'E', 'E'},
                                                    {'O', 'E', 'O', 'O'}
                                                  };

    private static final int ROW = M.length;
    private static final int COL = M[0].length;
    private static int area = 0;
    private static final boolean[][] visited = new boolean[ROW][COL];

    private static final int[] rowIdx = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] colIdx = {-1, 0, 1, -1, 1, -1, 0, 1};


    private static boolean isSafe(int row, int col) {
        return row >= 0 && row < ROW && col >= 0 && col < COL && M[row][col] == 'E' && !visited[row][col];
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

    private static int findMaxEnemyKilled() {
        int maxEnemyKilled = 0;
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                if (M[row][col] == 'E' && !visited[row][col]) {
                    area = 1;
                    DFS(row, col);
                    maxEnemyKilled = max(maxEnemyKilled, area);
                }
            }
        }
        return maxEnemyKilled;
    }

    public static void main(String[] args) {
        System.out.println("Max Enemy Killed " + findMaxEnemyKilled());
    }
}
