package matrix;

public class WordSearch {

    char[][] M = {
            {'A', 'B', 'H', 'I'},
            {'M', 'A', 'R', 'N'},
            {'U', 'K', 'W', 'A'}
    };
    int ROW = M.length;
    int COL = M[0].length;
    int[] rowIdx = {1, -1, 0, 0};
    int[] colIdx = {0, 0, 1, -1};

    boolean DFS(int row, int col, String word, int index) {
        if (index >= word.length()) {
            return true;
        }
        if (row < 0 || row >= ROW || col < 0 || col >= COL || M[row][col] != word.charAt(index)){
            return false;
        }
        char t = M[row][col];
        M[row][col] = '*';
        for (int k = 0; k < 4; k++) {
            if (DFS(row + rowIdx[k], col + colIdx[k], word, index + 1)) {
                return true;
            }
        }
        M[row][col] = t;
        return false;
    }

    boolean exist(String word) {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (DFS(i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new WordSearch().exist("Abhinaw".toUpperCase()));
    }
}
