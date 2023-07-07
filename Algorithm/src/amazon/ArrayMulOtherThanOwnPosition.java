package amazon;

import java.util.stream.IntStream;

// Time  Complexity  O(n)
// Space Complexity  O(n)

public class ArrayMulOtherThanOwnPosition {

    private static int[] productExceptSelf(int[] nums) {
        int[] a = new int[nums.length];
        a[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            a[i] = a[i - 1] * nums[i - 1];
        }
        for (int k = 1, i = nums.length - 1; i >= 0; i--) {
            a[i]  *= k;
            k *= nums[i];
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = productExceptSelf(new int[] {1, 2, 0});
        IntStream.range(0, a.length).forEach(i -> System.out.print(a[i] + " "));
    }
}
