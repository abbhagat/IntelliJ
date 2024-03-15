package pairs;

import java.util.Arrays;

import static java.lang.Math.abs;

public class ClosestSumPairInAnArray {

    private static void findPair(int[] a) {
        Arrays.sort(a);
        int i = 0, j = a.length - 1, x = 0, y = 0, n = 47;
        int diff = Integer.MAX_VALUE;
        while (i < j) {
            int mul = abs(a[i] + a[j] - n);
            if (mul < diff) {
                x = a[i];
                y = a[j];
                diff = mul;
            }
            int k = a[i] + a[j] < n ? i++ : j--;
        }
        System.out.println("The closest pair is " + x + " and " + y);
    }

    public static void main(String[] args) {
        findPair(new int[]{10, 22, 28, 29, 30, 40});
    }
}
