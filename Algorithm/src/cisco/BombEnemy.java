package cisco;

import static java.lang.Integer.max;

public class BombEnemy {

    private static char[][] M = new char[][]{
            {'O', 'E', 'O', 'O'},
            {'E', 'O', 'E', 'E'},
            {'O', 'E', 'O', 'O'}
    };

    private static int ROW = M.length;
    private static int COL = M[0].length;
    private static int area = 0;
    private static boolean[][] visited = new boolean[ROW][COL];


    private static boolean isSafe(int row, int col) {
        return row >= 0 && row < ROW && col >= 0 && col < COL && M[row][col] == 'E' && !visited[row][col];
    }

    private static void DFS(int row, int col) {
        int[] rowIdx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colIdx = {-1, 0, 1, -1, 1, -1, 0, 1};
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
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (M[i][j] == 'E' && !visited[i][j]) {
                    area = 1;
                    DFS(i, j);
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
