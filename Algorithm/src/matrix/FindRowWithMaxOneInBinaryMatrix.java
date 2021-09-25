package matrix;

/**
 * Given a boolean 2D array, where each row is sorted. Find the row with the maximum number of 1s.
 * <p>
 * Example:
 * <p>
 * Input matrix
 * 0 1 1 1
 * 0 0 1 1
 * 1 1 1 1  // this row has maximum 1s
 * 0 0 0 0
 * <p>
 * Output: 2
 */

public class FindRowWithMaxOneInBinaryMatrix {

    private static int M[][] = {
            {1, 0, 0, 1},
            {0, 0, 1, 1},
            {0, 0, 0, 0},
            {0, 1, 1, 1}
    };
    private static int R = M.length, C = M[0].length;

    private static int binarySearch(int a[], int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if ((mid == 0 || (a[mid - 1] == 0)) && a[mid] == 1) {
                return mid;
            }
            return a[mid] == 0 ? binarySearch(a, mid + 1, high) : binarySearch(a, low, mid - 1);
        }
        return a.length - 1;
    }

    private static int rowWithMax1s(int mat[][]) {
        int max_row_index = 0, max = 0;
        for (int i = 0; i < R; i++) {
            int index = binarySearch(mat[i], 0, C - 1);
            if (C - index > max) {
                max = C - index;
                max_row_index = i;
            }
        }
        return max_row_index;
    }

    private static int rowWithMax0s(int mat[][]) {
        int max_row_index = 0, max = 0;
        for (int i = 0; i < R; i++) {
            int index = binarySearch(mat[i], 0, C - 1);
            if (index >= max) {
                max = index;
                max_row_index = i;
            }
        }
        return max_row_index;
    }

    public static void main(String[] args) {
        System.out.println("Index of row with maximum 1s is " + rowWithMax1s(M));
        System.out.println("Index of row with maximum 0s is " + rowWithMax0s(M));
    }
}
