package adobe;

import java.util.Arrays;

public class MissingNumberInSortedArray {
    private static int findMissingNumber(int[] a) {
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] > mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] a = {9, 7, 3, 5, 10, 1, 2, 8, 6, 0};
        Arrays.sort(a);
        System.out.println(findMissingNumber(a));
    }
}
