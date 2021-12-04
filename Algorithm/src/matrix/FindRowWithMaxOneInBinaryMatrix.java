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

    private static int rowWithMax1s(int[] a, int low, int high) {
        if (a[low] == 1) {
            return high - low + 1;
        }
        if (a[high] == 0) {
            return 0;
        }
        int mid = (low + high) / 2;
        return rowWithMax1s(a, low, mid) + rowWithMax1s(a, mid + 1, high);
    }

    private static int rowWithMax0s(int[] a, int low, int high) {
        if (a[low] == 1) {
            return 0;
        }
        if (a[high] == 0) {
            return high - low + 1;
        }
        int mid = (low + high) / 2;
        return rowWithMax0s(a, low, mid) + rowWithMax0s(a, mid + 1, high);
    }

    public static void main(String[] args) {
        int[][] M = {
                {0, 0, 0, 1},
                {0, 0, 1, 1},
                {0, 0, 0, 0},
                {0, 1, 1, 1}
        };
        int maxOneRowIndex = 0, maxZeroRowIndex = 0, maxCountOne = 0, maxCountZero = 0;
        for (int i = 0; i < M.length; i++) {
            int countOne = rowWithMax1s(M[i], 0, M[i].length - 1);
            if (maxCountOne < countOne) {
                maxCountOne = countOne;
                maxOneRowIndex = i;
            }
            int countZero = rowWithMax0s(M[i], 0, M[i].length - 1);
            if (maxCountZero < countZero) {
                maxCountZero = countZero;
                maxZeroRowIndex = i;
            }
        }
        System.out.println("MaxOneRowIndex  " + maxOneRowIndex);
        System.out.println("MaxZeroRowIndex " + maxZeroRowIndex);
    }
}
