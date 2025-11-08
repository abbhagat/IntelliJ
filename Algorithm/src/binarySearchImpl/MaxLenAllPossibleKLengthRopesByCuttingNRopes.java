package binarySearchImpl;

import java.util.Arrays;

/**
 * Given an array arr[] consisting of N positive integers representing the lengths of N ropes and a positive integer K,
 * the task is to find the maximum length of the rope that has a frequency of at least K by cutting any ropes in any number of pieces.
 * Examples:
 * Input: arr[] = {5, 2, 7, 4, 9}, K = 5 Output: 4
 * Explanation:
 * Below are the possible cutting of the ropes:
 * arr[0](= 5) is cut into {4, 1}.
 * arr[2](= 7) is cut into {4, 3}.
 * arr[4](= 9) is cut into {4, 4, 1}.
 * After the above combinations of cuts, the maximum length is 4, which is of frequency at least(K = 5).
 * Input: arr[] = {1, 2, 3, 4, 9}, K = 6 Output: 2
 * Approach: The given problem can be solved by using the Binary Search. Follow the steps below to solve the problem:
 * Initialize 3 variables, say low as 1, high as the maximum value of array arr[], and result as -1,
 * to store the left boundary right boundary for the binary search and to store the maximum possible length of K ropes.
 * Iterate until low is less than high and perform the following steps:
 * Find the mid-value of the range [low, high] and store it in a variable say mid.
 * Traverse the array a[] and find the count of ropes of length mid that can be obtained by cutting the ropes and store it in a variable say, count.
 * If the value of count is at least K, then update the value of mid as result and update the value of low as (mid + 1).
 * Otherwise, update the value of high as (mid – 1).
 * After completing the steps, print the value of result as the result.
 */
//  Time Complexity : O(N * log(max(arr)))
//  Space Complexity : O(1)
public class MaxLenAllPossibleKLengthRopesByCuttingNRopes {

    private static int maximumSize(int[] a, int k) {
        int low = 0, high = Arrays.stream(a).max().getAsInt(), result = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            int count = 0;
            for (int x : a) {
                count += x / mid;
            }
            if (count >= k) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maximumSize(new int[]{1, 2, 3, 4, 9}, 6));
        System.out.println(maximumSize(new int[]{5, 2, 7, 4, 9}, 5));
    }
}
