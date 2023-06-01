package matrix;

// Time Complexity O(n log n)
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

    public static void main(String[] args) {
        int[][] M = {
                      {0, 0, 0, 1},
                      {0, 0, 1, 1},
                      {0, 0, 0, 0},
                      {0, 1, 1, 1}
                    };
        int index = 0, count = 0;
        for (int i = 0; i < M.length; i++) {
            int countOne = rowWithMax1s(M[i], 0, M[i].length - 1);
            if (count < countOne) {
                count = countOne;
                index = i;
            }
        }
        System.out.println("MaxOneRowIndex  " + index);
    }
}
