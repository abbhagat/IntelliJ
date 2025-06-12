package amazon;

import static util.CommonUtils.printArray;
import static util.CommonUtils.swap;

// Time  Complexity : O(n)
// Space Complexity : O(1)
public class ReArrangePositiveAndNegativeNumber {

    private static void reArrangePositiveAndNegativeNumber(int[] a) {
        int i = 0, j = 1;
        while (i < a.length && j < a.length) {
            if (a[i] > 0) {
                i += 2;
            } else if (a[j] <= 0) {
                j += 2;
            } else {
                swap(a, i, j);
                j = i + 1;
                i += 2;
            }
        }
        printArray(a);
    }

    public static void main(String[] args) {
        reArrangePositiveAndNegativeNumber(new int[]{1, 2, 3, -4, -1, 4});
        System.out.println();
        reArrangePositiveAndNegativeNumber(new int[]{-5, -7, 9, 11, 12, -15, 17});
        System.out.println();
        reArrangePositiveAndNegativeNumber(new int[]{-5, -2, 5, 2, 4, 7, 1, 8, 0, -8});
    }
}
