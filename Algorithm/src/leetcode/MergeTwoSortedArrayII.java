package leetcode;

import static util.CommonUtils.printArray;

// Input : a = {4, 7, 10}; b = {3, 6, 15, 20};
// Output: a = {3,4,6}     b = {7, 10, 15, 20}
// Time  Complexity O(n)
// Space Complexity O(1)
public class MergeTwoSortedArrayII {

    public static void main(String[] args) {
        int[] a = {4, 7, 10};
        int[] b = {3, 6, 15, 20};
        int i = 0, j = 0;
        while (i < a.length && j + 1 < b.length) {
            if (a[i] > b[j]) {
                int t = a[i];
                a[i] = b[j];
                b[j] = t;
                if (b[j] > b[j + 1]) {
                    j++;
                }
            }
            i++;
        }
        printArray(a);
        printArray(b);
    }
}
