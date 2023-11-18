package leetcode;

// Time  Complexity: O(n)
// Space Complexity: O(n)

import java.util.Arrays;

public class PrintMissingRangeFrom0To99 {

    private static void printMissingRange(int[] a, int start, int end) {
        Arrays.sort(a);
        boolean[] isPresent = new boolean[end + 2];
        isPresent[end + 1] = true;
        for (int x : a) {
            if (x >= start && x <= end) {
                isPresent[x] = true;
            }
        }
        int index = -1;
        for (int i = start; i < isPresent.length; i++) {
            if (!isPresent[i]) {
                index = index == -1 ? i : index;
            } else {
                if (index != -1) {
                    System.out.println(i == index + 1 ? index : index + "-" + (i - 1));
                    index = -1;
                }
            }
        }
        System.out.println();
    }

    private static void printMissingRanges(int[] a) {
        Arrays.sort(a);
        for (int i = 1; i < a.length; i++) {
            if(a[i] - a[i - 1] == 1) {
                continue;
            }
            if (a[i] - a[i - 1] > 2) {
                System.out.print(a[i - 1] + 1 + "-" + (a[i] - 1) + " ");
            } else if (a[i] - a[i - 1] != 1) {
                System.out.print(a[i] - 1 + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printMissingRanges(new int[]{2, 3, 4, 6, 9, 10});
        printMissingRanges(new int[]{88, -1, 105, 3, 2, 200, 10});
        printMissingRanges(new int[]{88, -1, 105, 3, 2, 200, 0, 10});
        printMissingRanges(new int[]{88, -1, 105, 3, 2, 200, 0, 10});
    }
}
