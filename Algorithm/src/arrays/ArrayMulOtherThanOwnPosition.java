package arrays;

import java.util.stream.IntStream;

public class ArrayMulOtherThanOwnPosition {

    private static int[] productExceptSelf(int[] nums) {
        int mul = 1;
        int[] a = new int[nums.length];
        System.arraycopy(nums, 0, a, 0, nums.length);
        for (int x : nums) {
            mul *= x;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] == 0 ? product(a, i) : mul / nums[i];
        }
        return nums;
    }

    private static int product(int[] nums, int index) {
        int mul = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i == index) {
                continue;
            }
            mul *= nums[i];
        }
        return mul;
    }

    public static void main(String[] args) {
        int[] a = productExceptSelf(new int[]{-1, 1, 0, -3, 3});
        IntStream.range(0, a.length).forEach(i -> System.out.print(a[i] + " "));
    }
}
