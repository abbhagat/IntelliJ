package arrays;

import java.util.Arrays;

import static util.CommonUtils.printArray;

// Time Complexity O(n^2)
public class ArrayDelete3rdElement {

    private static void modifyArray(int[] a, int pos) {
        pos--;
        int n = a.length;
        for (int i = pos; i < n; i += pos) {
            System.arraycopy(a, i + 1, a, i, n - i - 1);
            n--;
        }
        Arrays.fill(a, n, a.length, 0);
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        modifyArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 3);
        modifyArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5);
    }
}
