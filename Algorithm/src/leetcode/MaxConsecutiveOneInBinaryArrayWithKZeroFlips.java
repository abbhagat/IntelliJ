package leetcode;

import java.util.stream.IntStream;

/*
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]

 */
public class MaxConsecutiveOneInBinaryArrayWithKZeroFlips {

    private static int findZeroes(int[] nums, int k) {
        int wL = 0, wR = 0;                     // Left and right indexes of current window
        int bestL = 0, bestWindow = 0;         // Left index and size of the widest window
        int zeroCount = 0;                    // Count of zeroes in current window
        while (wR < nums.length) {           // While right boundary of current window doesn't cross right end
            if (zeroCount <= k) {           // If zero count of current window is less than m widen the window toward right
                zeroCount += nums[wR] == 0 ? 1 : 0;
                wR++;
            }
            if (zeroCount > k) {         // If zero count of current window is more than k reduce the window from left
                zeroCount -= nums[wL] == 0 ? 1 : 0;
                wL++;
            }
            if (wR - wL > bestWindow && zeroCount <= k) {   // Update widest window if this window size is more
                bestWindow = wR - wL;
                bestL = wL;
            }
        }
        for (int i = bestL; i < bestWindow + bestL; i++) {    // Print positions of zeroes in the widest window
            if (nums[i] == 0) {
                nums[i] = 1;
                System.out.print(i + " ");
            }
        }
        System.out.println("\nChanged Array After Flip");
        IntStream.range(0, nums.length).forEach(i -> System.out.print(nums[i] + " "));
        return bestWindow;
    }

    public static void main(String[] args) {
        int a[] = new int[]{1, 0, 0, 1, 1, 0, 1, 0, 1, 1};
        int k = 2;
        System.out.println("\n" + findZeroes(a, k));
    }
}
