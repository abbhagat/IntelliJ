package geeks;

import java.util.Arrays;

public class CountOneInSortedBinaryArray {

    private static int[] a = {0, 0, 0, 1, 1, 1, 1, 1, 1};

    private static int countOnes(int low, int high) {
        if (a[low] == 1) {
            return high - low + 1;
        }
        if (a[high] == 0) {
            return 0;
        }
        int mid = (low + high) / 2;
        return countOnes(low, mid) + countOnes(mid + 1, high);
    }

    private static int countZero(int low, int high) {
        if (a[low] == 1) {
            return 0;
        }
        if (a[high] == 0) {
            return high - low + 1;
        }
        int mid = (low + high) / 2;
        return countZero(low, mid) + countZero(mid + 1, high);
    }

    public static void main(String[] args) {
        Arrays.sort(a);
        System.out.println(countOnes(0, a.length - 1));
        System.out.println(countZero(0, a.length - 1));
    }
}
