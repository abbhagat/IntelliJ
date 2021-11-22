package gfg;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class LargestContiguousProductArrayPrint {

    private static void maxSubarrayProduct(int[] a) {
        int max = a[0], min = a[0], maxProduct = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < 0) {
                int t = max;
                max = min;
                min = t;
            }
            max = max(a[i], max * a[i]);
            min = min(a[i], min * a[i]);
            maxProduct = max(maxProduct, max);
        }
        System.out.println(maxProduct);
    }

    public static void main(String[] args) {
        maxSubarrayProduct(new int[]{-2, -40, 0, -2, -3});
        maxSubarrayProduct(new int[]{-1, -2, 10, -10});
        maxSubarrayProduct(new int[]{2, 3, -2, 4});
        maxSubarrayProduct(new int[]{-2,0,-1});
    }
}
