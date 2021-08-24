package geeks;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class LargestContiguousProductArrayPrint {

    private static int maxSubarrayProduct(int a[]) {
        int max_end = 1;            // max positive product ending at the current position
        int min_end = 1;           // min negative product ending at the current position
        int max_product = 0;      // Initialize overall max product
        /* Traverse through the array. Following values are maintained after the ith iteration:
        max_end is always 1 or some positive product ending with a[i]
        min_end is always 1 or some negative product ending with a[i] */
        for (int i = 0; i < a.length; i++) {
            /* If this element is positive, update max_end. Update min_end only if min_end is negative */
            if (a[i] > 0) {
                max_end = max_end * a[i];
                min_end = min(min_end * a[i], 1);
            } else if (a[i] == 0) {  // If this element is 0, then the maximum product cannot end here,
                max_end = 1;  // make both max_end and min_ending _here 0. Assumption: Output is alway greater than or equal to 1.
                min_end = 1;
            }
            /* If element is negative. This is tricky max_end can either be 1 or positive.
            min_end can either be 1 or negative. next min_end will always be prev.
            max_end * a[i] next max_end will be 1 if prev min_end is 1, otherwise
            next max_end will be prev min_end * a[i] */
            else {
                int temp = max_end;
                max_end = max(min_end * a[i], 1);
                min_end = temp * a[i];
            }
            max_product = max_product < max_end ? max_end : max_product;   // update max_product, if needed
        }
        return max_product == 0 ? 0 : max_product;
    }

    public static void main(String[] args) {
        int a[] = {-2, -40, 0, -2, -3};
        System.out.println("Maximum Sub array product is " + maxSubarrayProduct(a));
        a = new int[]{-2, 0, 0, -2, -3};
        System.out.println("Maximum Sub array product is " + maxSubarrayProduct(a));
    }
}
