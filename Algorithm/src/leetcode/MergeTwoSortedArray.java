package leetcode;

import java.util.stream.IntStream;

public class MergeTwoSortedArray {

    private static void mergeTwoSortedArray(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                c[k++] = a[i++];
                j++;
            } else {
                c[k++] = a[i] < b[j] ? a[i++] : b[j++];
            }
        }
        while (i < a.length) {
            c[k++] = a[i++];
        }
        while (j < b.length) {
            c[k++] = b[j++];
        }
        IntStream.range(0, k).forEach(l -> System.out.print(c[l] + " "));
    }

    public static void main(String[] args) {
        mergeTwoSortedArray(new int[]{1, 2, 5, 6, 10}, new int[]{1, 3, 4, 7, 8, 9, 10});
    }
}
