package binarySearchImpl;

/*
  Given two integers W and C, representing the number of watermelons and coins,
  the task is to find the maximum number of mangoes that can be bought given
  that each mango costs 1 watermelon and X coins and y coins can be earned selling a watermelon.
  Input: W = 10, C = 10, X = 1, Y = 1
  Output: 10
  Explanation: The most optimal way is to use 10 watermelons and 10 coins to buy 10 mangoes. Hence, the maximum number of mangoes that can be bought is 10.
  Input: W = 4, C = 8, X = 4, Y = 4
  Output: 3
  Explanation: The most optimal way is to sell one watermelon. Then, the number of coins increases by 4.
  Therefore, the total number of coins becomes 12. Therefore, 3 watermelons and 12 coins can be used to buy 3 mangoes.
  Hence, the maximum number of mangoes that can be bought is 3.
  Approach: This problem can be solved using binary search. The idea is to find the maximum number of mangoes in the search space.
  Follow the steps below to solve the problem:
  Initialize a variable ans as 0 to store the required result.
  Initialize two variables l as 0, r as W to store the boundary regions of the search space for binary search.
  Loop while l≤r and perform the following steps:
  Store the middle value in a variable mid as (l+r)/2.
  Check if mid number of mangoes can be bought using the given value of W, C, x, and y.
  If true, then update ans to mid and search in the right part of mid by updating l to mid+1. Otherwise, update the value of r to mid-1.
  Print the value of ans as the result
 */

// Time Complexity: O(log(W))
// Auxiliary Space: O(1)
public class MaxMango {

    private static boolean check(int W, int C, int x, int y, int mid) {
        if (mid > W) {                        // If watermelons needed are greater than given watermelons
            return false;
        }
        int remainingWaterMelon = W - mid;
        int coinsEarned = remainingWaterMelon * y;
        C += coinsEarned;
        int mangoes = C / x;
        return mangoes >= mid ? true : false;
    }

    private static int maximizeMangoes(int W, int C, int x, int y) {
        int low = 0, high = W, result = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (check(W, C, x, y, mid)) {      // Check if it is possible to buy mid number of mangoes
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int W = 4, C = 8, x = 4, y = 4;
        System.out.println(maximizeMangoes(W, C, x, y));
    }
}
