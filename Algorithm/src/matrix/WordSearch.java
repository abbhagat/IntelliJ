package matrix;

public class WordSearch {

    private static char[][] M = {
            {'A', 'B', 'H', 'I'},
            {'S', 'F', 'C', 'N'},
            {'A', 'D', 'W', 'A'}
    };
    private static int ROW = M.length;
    private static int COL = M[0].length;

    private static boolean DFS(int row, int col, String word, int index) {
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
            if (DFS(row + rowIdx[k], col + colIdx[k], word, index + 1))
                return true;
        }
        M[row][col] = t;
        return false;
    }

    private static boolean exist(char[][] M, String word) {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (DFS(i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String args[]) {
        System.out.println(exist(M, "ABHINAW"));
    }
}
