package arrays;

import java.util.Arrays;

/**
 * Input   : arr[] = [2, 3, 5, 9] and  x = 47
 * Output : {5, 9}
 * <p>
 * Input   : arr[] = [2, 3, 5, 9] and  x = 8
 * Output : {2, 5}
 */

public class ClosestProductPairInAnArray {

    public static void main(String[] args) {
        int[] a = {2, 3, 5, 9};
        Arrays.sort(a);
        int i = 0, j = a.length - 1, x = 0, y = 0, n = 45;
        int diff = Integer.MAX_VALUE;
        while (i < j) {
            int sum = Math.abs(a[i] * a[j] - n);
            if (sum < diff) {
                x = i;
                y = j;
                diff = sum;
            }
            int k = (a[i] * a[j] < n) ? i++ : j--;
        }
        System.out.println("The closest pair is " + a[x] + " and " + a[y]);
    }
}
