package sorting;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int[] a = {20, 3, 45, 15, 6, 19, 8, 2, 1, 35, 123};
        Arrays.sort(a);
        System.out.println(binarySearch(a, 0, a.length - 1, 135) ? "Present" : "Not Present");
    }

    private static boolean binarySearch(int[] a, int low, int high, int n) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (n == a[mid]) {
                return true;
            }
            return n < a[mid] ? binarySearch(a, low, mid - 1, n) : binarySearch(a, mid + 1, high, n);
        }
        return false;
    }
}
