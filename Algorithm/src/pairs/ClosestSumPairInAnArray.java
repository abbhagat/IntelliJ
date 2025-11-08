package pairs;

import java.util.Arrays;

import static java.lang.Math.abs;

// Time  Complexity : O(n log n)
// Space Complexity : O(1)
public class ClosestSumPairInAnArray {

    private static void findPair(int[] a, int n) {
        Arrays.sort(a);
        int i = 0, j = a.length - 1, x = 0, y = 0;
        int min = Integer.MAX_VALUE;
        while (i < j) {
            int diff = abs(a[i] + a[j] - n);
            if (diff < min) {
                x = a[i];
                y = a[j];
                min = diff;
            }
            int k = a[i] + a[j] < n ? i++ : j--;
        }
        System.out.println("The closest pair is " + x + " and " + y);
    }

    public static void main(String[] args) {
        findPair(new int[]{10, 22, 28, 29, 30, 40}, 47);
        findPair(new int[]{10, 22, 28, 29, 30, 40}, 17);
    }
}
