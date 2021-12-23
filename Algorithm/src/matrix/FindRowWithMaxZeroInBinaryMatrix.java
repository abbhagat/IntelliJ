package matrix;

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
        int index = 0, count = 0;
        for (int i = 0; i < M.length; i++) {
            int countZero = rowWithMax0s(M[i], 0, M[i].length - 1);
            if (count < countZero) {
                count = countZero;
                index = i;
            }
        }
        System.out.println("MaxZeroRowIndex " + index);
    }
}
