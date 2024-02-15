package leetcode;

import java.util.Arrays;

public class SummaryRanges {
    private static void printSummaryRanges(int[] a) {
        Arrays.sort(a);
        int start = a[0], end = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] - a[i - 1] == 1) {
                end = a[i];
            } else {
                System.out.println(start + (end == 0 ? "" : "-" + end));
                start = a[i];
                end = 0;
            }
        }
        System.out.println(start + (end == 0 ? "" : "-" + end));
    }

    public static void main(String[] args) {
        printSummaryRanges(new int[]{0, 1, 2, 4, 5, 7});
        System.out.println();
        printSummaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9});
    }
}
