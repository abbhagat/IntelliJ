package amazon;

import static util.CommonUtils.printArray;

// Time  Complexity : O(n)
// Space Complexity : O(n)
public class ArrayMulOtherThanOwnPosition {

    private static int[] productExceptSelf(int[] nums) {
        int[] a = new int[nums.length];
        a[0] = 1;
        for (int i = 1; i < a.length; i++) {
            a[i] = a[i - 1] * nums[i - 1];
        }
        for (int i = a.length - 1, k = 1; i >= 0; i--) {
            a[i] *= k;
            k *= nums[i];
        }
        return a;
    }

    public static void main(String[] args) {
        printArray(productExceptSelf(new int[]{1, 2, 0}));
        printArray(productExceptSelf(new int[]{1, 2, 3}));
    }
}
