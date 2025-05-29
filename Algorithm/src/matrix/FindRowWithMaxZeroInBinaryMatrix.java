package matrix;

// Time Complexity : O(n log n)
public class FindRowWithMaxZeroInBinaryMatrix {

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
        int index = 0, max = 0;
        for (int i = 0; i < M.length; i++) {
            int maxCount = rowWithMax0s(M[i], 0, M[i].length - 1);
            if (max < maxCount) {
                max = maxCount;
                index = i;
            }
        }
        System.out.println("Index With Max Zero  " + index);
    }
}
