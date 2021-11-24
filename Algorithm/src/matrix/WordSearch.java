package matrix;

public class WordSearch {

    private static char[][] M = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
    };
    private static int ROW = M.length;
    private static int COL = M[0].length;

    private static boolean exist(char[][] M, String word) {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (DFS(i, j, M, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean DFS(int row, int col, char[][] M, String word, int index) {
        if (index >= word.length()) {
            return true;
        }
        if (row < 0 || row >= ROW || col < 0 || col >= COL || M[row][col] != word.charAt(index)){
            return false;
        }
        char t = M[row][col];
        M[row][col] = '#';
        int rowIdx[] = {0, 1, 0, -1};
        int colIdx[] = {1, 0, -1, 0};
        for (int k = 0; k < 4; k++) {
            if (DFS(row + rowIdx[k], col + colIdx[k], M, word, index + 1))
                return true;
        }
        M[row][col] = t;
        return false;
    }

    public static void main(String args[]) {
        System.out.println(exist(M, "ABCCED"));
    }
}
