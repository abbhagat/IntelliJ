package arrays;

import java.util.Arrays;

public class ClosestSumInAnArray {

    public static void main(String[] args) {
        int[] a = {2, 5, 8, 1, 9, 3};
        int i, j, x, y, diff, n;
        i = x = y = 0;
        j = a.length - 1;
        diff = Integer.MAX_VALUE;
        n = 15;
        Arrays.sort(a);
        while (i < j) {
            int sum = Math.abs(a[i] + a[j] - n);
            if (sum < diff) {
                x = i;
                y = j;
                diff = sum;
            }
            int k = (a[i] + a[j] - n) < 0 ? i++ : j--;
        }
        System.out.println(a[x] + " " + a[y]);
    }
}
