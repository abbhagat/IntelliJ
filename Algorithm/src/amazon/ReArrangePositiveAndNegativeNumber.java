package amazon;

import java.util.stream.IntStream;

// Time  Complexity  O(n)
// Space Complexity  O(1)

public class ReArrangePositiveAndNegativeNumber {

    private static void reArrangePositiveAndNegativeNumber(int[] a) {
        int i = 0, j = 1;
        while (i < a.length && j < a.length) {
            if (a[i] < 0) {
                i += 2;
            } else if (a[j] >= 0) {
                j++;
            } else if (a[i] > 0 && a[j] < 0) {
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
                j = i + 1;
                i += 2;
            }
        }
        IntStream.range(0, a.length).forEach(k -> System.out.print(a[k] + " "));
        System.out.println();
    }

    public static void main(String[] args) {
        reArrangePositiveAndNegativeNumber(new int[]{1, 2, 3, -4, -1, 4});
        reArrangePositiveAndNegativeNumber(new int[]{-5, -7, 9, 11, 12, -15, 17});
        reArrangePositiveAndNegativeNumber(new int[]{-5, -2, 5, 2, 4, 7, 1, 8, 0, -8});
    }
}
