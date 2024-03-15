package matrix;

import java.util.HashSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class NumOfDistinctIsland {

    private static final int[][] M = new int[][]{
                                                  {1, 1, 0, 0, 0},
                                                  {1, 1, 0, 0, 0},
                                                  {0, 0, 0, 1, 1},
                                                  {0, 0, 0, 1, 1}
                                                };

    private static final int ROW = M.length;
    private static final int COL = M[0].length;

    private static final boolean[][] visited = new boolean[ROW][COL];
    private static final int[] rowIdx = new int[]{-1, 1, 0, 0};
    private static final int[] colIdx = new int[]{0, 0, -1, 1};

    private static boolean isSafe(int row, int col) {
        return row >= 0 && row < ROW && col >= 0 && col < COL && M[row][col] == 1 && !visited[row][col];
    }

    private static void DFS(int row, int col, int row0, int col0, List<String> list) {
        visited[row][col] = true;
        list.add(toString(row - row0, col - col0));
        for (int k = 0; k < 4; k++) {
            if (isSafe(row + rowIdx[k], col + colIdx[k])) {
                DFS(row + rowIdx[k], col + colIdx[k], row0, col0, list);
            }
        }
    }

    private static String toString(int row, int col) {
        return row + " " + col;
    }

    private static int countDistinctIslands() {
        Set<List<String>> set = new HashSet<>();
        for (int row = 0; row < ROW; row++)
            for (int col = 0; col < COL; col++)
                if (M[row][col] == 1 && !visited[row][col]) {
                    List<String> list = new ArrayList<>();
                    DFS(row, col, row, col, list);
                    set.add(list);
                }
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println("Number of Distinct Islands is: " + countDistinctIslands());
    }
}
