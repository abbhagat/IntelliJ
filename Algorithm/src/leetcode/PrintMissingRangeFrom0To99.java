package leetcode;

// Time  Complexity: O(n)
// Space Complexity: O(n)

import java.util.Arrays;

public class PrintMissingRangeFrom0To99 {
    private static void printMissingRanges(int[] a, int start, int end) {
        Arrays.sort(a);
        if (a[0] > start) {
            System.out.print(start + "-" + (a[0] - 1) + " ");
        }
        for (int i = 1; i < a.length; i++) {
            int diff = a[i] - a[i - 1];
            switch (diff) {
                case 1 : continue;
                case 2 : System.out.print(a[i] - 1 + " "); break;
                default: System.out.print(a[i - 1] + 1 + "-" + (a[i] - 1) + " ");
            }
        }
        if (a[a.length - 1] < end) {
            System.out.print(a[a.length - 1] + 1 + "-" + end);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printMissingRanges(new int[]{2, 3, 4, 6, 9, 10}, 0, 99);
        printMissingRanges(new int[]{88, -1, 105, 3, 2, 200, 10}, 10, 50);
        printMissingRanges(new int[]{88, -1, 105, 3, 2, 200, 0, 10}, 40, 100);
        printMissingRanges(new int[]{88, -1, 105, 3, 2, 200, 0, 10}, 60, 1000);
    }
}
