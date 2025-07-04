package geeksforgeeks;

import java.util.Arrays;

/**
Given a binary array a and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

Input: a = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6 Explanation: [1,1,1,0,0,1,1,1,1,1,1]

Input: a = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10 Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
*/
public class MaxConsecutiveOneInBinaryArrayWithKZeroFlips {

    private static void slidingWindow(int[] a, int k) {
        int wL, wR, startIndex, bestWindow, zeroCount;
        wL = wR = startIndex = bestWindow = zeroCount = 0;
        while (wR < a.length) {
            if (zeroCount <= k) {
                zeroCount += a[wR] == 0 ? 1 : 0;
                wR++;
            }
            if (zeroCount > k) {
                zeroCount -= a[wL] == 0 ? 1 : 0;
                wL++;
            }
            if (wR - wL > bestWindow && zeroCount <= k) {
                bestWindow = wR - wL;
                startIndex = wL;
            }
        }
        System.out.print("Index Flipped ");
        for (int i = startIndex; i < startIndex + bestWindow; i++) {
            if (a[i] == 0) {
                a[i] = 1;
                System.out.print(i + " ");
            }
        }
        System.out.println("\nChanged Array After Flip " + Arrays.toString(a));
        System.out.println("Max Consecutive 1's: " + bestWindow);
    }

    public static void main(String[] args) {
        slidingWindow(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2);
        slidingWindow(new int[]{1, 0, 0, 1, 1, 0, 1, 0, 1, 1}, 2);
        slidingWindow(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3);
    }
}
