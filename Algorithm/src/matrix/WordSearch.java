package matrix;

public class WordSearch {

    private static final char[][] M = {
            {'A', 'B', 'H', 'I'},
            {'M', 'A', 'R', 'N'},
            {'U', 'K', 'W', 'A'}
    };
    private static final int ROW = M.length;
    private static final int COL = M[0].length;
    private static final int[] rowIdx = new int[]{-1, 1, 0, 0};
    private static final int[] colIdx = new int[]{0, 0, -1, 1};

    private static boolean DFS(int row, int col, String word, int index) {
        if (index >= word.length()) {
            return true;
        }
        if (row < 0 || row >= ROW || col < 0 || col >= COL || M[row][col] != word.charAt(index)) {
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

    private static boolean exist(String word) {
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                if (DFS(row, col, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(exist("ABHINAW") ? "Present" : "Not Present");
        System.out.println(exist("KUMAR") ? "Present" : "Not Present");
    }
}
