package leetcode;

import java.util.Arrays;

public class PrintMissingRangeInSortedArray {

    private static void printMissingRange(int[] a) {
        Arrays.sort(a);
        for (int i = 1; i < a.length; i++) {
            if (a[i] - a[i - 1] == 1) {
                continue;
            }
            if (a[i] - a[i - 1] == 3) {
                System.out.print(a[i - 1] + 1 + " " + (a[i - 1] + 2) + " ");
            } else if (a[i] - a[i - 1] > 2) {
                System.out.print(a[i - 1] + 1 + "-" + (a[i] - 1) + " ");
            } else if (a[i] - a[i - 1] != 1) {
                System.out.print(a[i] - 1 + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printMissingRange(new int[]{1, 2, 4, 7, 9, 10, 11, 15});
        printMissingRange(new int[]{2, 3, 4, 6, 9, 10});
        printMissingRange(new int[]{1, 2, 30, 33, 45, 60, 91, 910, 1100, 1500});
    }
}
