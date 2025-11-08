package sorting;

import static util.CommonUtils.printArray;

// Given an array and int value a,b,c. Apply f(x) = pow(a,2) + bx + c
// Time  Complexity O(n)
// Space Complexity O(n)
public class SortTransformedArray {

    private static int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] sorted = new int[n];
        int i = 0, j = n - 1, index = a >= 0 ? n - 1 : 0;
        while (i <= j) {
            if (a >= 0) {
                sorted[index--] = quad(nums[i], a, b, c) >= quad(nums[j], a, b, c) ? quad(nums[i++], a, b, c) : quad(nums[j--], a, b, c);
            } else {
                sorted[index++] = quad(nums[i], a, b, c) >= quad(nums[j], a, b, c) ? quad(nums[j--], a, b, c) : quad(nums[i++], a, b, c);
            }
        }
        return sorted;
    }

    private static int quad(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }

    public static void main(String[] args) {
        printArray(sortTransformedArray(new int[]{-4, -2, 2, 4}, 1, 3, 5));
        printArray(sortTransformedArray(new int[]{-4, -2, 2, 4}, -1, 3, 5));
    }
}
