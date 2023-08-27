package searching;

import java.util.Arrays;

public class IterativeBinarySearch {

    private static int binarySearch(int[] a, int n) {
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == n) {
                return mid;
            } else if (n < a[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{12, 15, 30, 35, 46, 55, 60, 72, 89, 92, 100};
        Arrays.sort(a);
        System.out.println(binarySearch(a, 60));
        System.out.println(binarySearch(a, 90));
    }
}
