package gfg;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class LargestContiguousProductArrayPrint {

    private static void maxSubarrayProduct(int[] nums) {
        int maxVal = nums[0], minVal = nums[0], maxProduct = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int t = maxVal;
                maxVal = minVal;
                minVal = t;
            }
            maxVal = max(nums[i], maxVal * nums[i]);
            minVal = min(nums[i], minVal * nums[i]);
            maxProduct = max(maxProduct, maxVal);
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
