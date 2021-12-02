package matrix;

public class SearchElementInSorted2DArraySortedRowAndColumnWise {

    private static boolean binarySearch(int M[][], int i, int low, int high, int n) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (M[i][mid] == n) {
                System.out.println("Found at (" + i + ", " + mid + ")");
                return true;
            }
            return n < M[i][mid] ? binarySearch(M, i, low, mid - 1, n) : binarySearch(M, i, mid + 1, high, n);
        }
        return false;
    }

    private static boolean search(int[][] M, int key) {
        int R1 = 0, R2 = M.length - 1;
        int C1 = 0, C2 = M[0].length - 1;
        int count = 0;
        while (R1 <= R2 && C1 <= C2) {
            if (key < M[R1][C2]) {
                C2--;
                count++;
            } else if (key > M[R1][C2]) {
                R1++;
            } else {
                System.out.println("[" + R1 + "]" + "[" + C2 + "]");
                return true;
            }
            if (count == 2 && binarySearch(M, R1, 0, C2, key)) {
                 return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] M;
        M = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(search(M, 5) ? "Present" : "Not Present");
        M = new int[][]{{1, 1}};
        System.out.println(search(M, 5) ? "Present" : "Not Present");
    }
}
