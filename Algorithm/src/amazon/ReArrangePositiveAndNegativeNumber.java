package amazon;

import java.util.stream.IntStream;

public class ReArrangePositiveAndNegativeNumber {

    private static void reArrangePositiveAndNegativeNumber(int[] a, int low, int high) {
        while (low <= high) {
            if (a[low] < 0) {
                low++;
            } else if (a[high] > 0) {
                high--;
            } else if (a[low] > 0 && a[high] < 0) {
                int t = a[low];
                a[low] = a[high];
                a[high] = t;
                low++;
                high--;
            } else {
                low++;
                high--;
            }
        }
        for (int i = 0, j = low; i + 1 < low; ) {
            if (a[i] < 0 && a[i + 1] < 0 && a[j] > 0) {
                int t = a[i + 1];
                a[i + 1] = a[j];
                a[j] = t;
                j++;
                low++;
                i += 2;
            } else {
                i++;
            }
        }
        for (int x : a) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    private static void reArrangePositiveAndNegativeNumber(int[] a) {
        for (int i = 0, j = 1; i < a.length && j < a.length; ) {
            if (a[i] < 0) {
                i += 2;
            } else if (a[j] >= 0) {
                j++;
            } else if (a[i] > 0 && a[j] < 0) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                j = i + 1;
                i += 2;
            }
        }
        IntStream.range(0, a.length).forEach(i -> System.out.print(a[i] + " "));
        System.out.println();
    }

    public static void main(String[] args) {
        reArrangePositiveAndNegativeNumber(new int[]{1, 2, 3, -4, -1, 4}, 0, 5);
        reArrangePositiveAndNegativeNumber(new int[]{-5, -7, 9, 11, 12, -15, 17}, 0, 6);
        reArrangePositiveAndNegativeNumber(new int[]{-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}, 0, 9);
        reArrangePositiveAndNegativeNumber(new int[]{1, 2, 3, -4, -1, 4});
        reArrangePositiveAndNegativeNumber(new int[]{-5, -7, 9, 11, 12, -15, 17});
        reArrangePositiveAndNegativeNumber(new int[]{-5, -2, 5, 2, 4, 7, 1, 8, 0, -8});
    }
}
