package geeksforgeeks;

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
        int wL, wR, bestL, bestWindow, zeroCount;
        wL = wR = bestL = bestWindow = zeroCount = 0;
        while (wR < nums.length) {
            if (zeroCount <= k) {
                if(nums[wR] == 0){
                    zeroCount++;
                }
                wR++;
            }
            if (zeroCount > k) {
                if(nums[wL] == 0){
                    zeroCount--;
                }
                wL++;
            }
            if (wR - wL > bestWindow && zeroCount <= k) {
                bestWindow = wR - wL;
                bestL = wL;
            }
        }
        for (int i = bestL; i < bestWindow + bestL; i++) {
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
