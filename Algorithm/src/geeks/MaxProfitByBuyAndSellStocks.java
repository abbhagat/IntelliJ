package geeks;

import java.util.Arrays;

/**
 * Given an array of positive integers containing the price of stocks and transaction fee,
 * the task is to find the maximum profit and the difference of days on which you are getting the maximum profit.
 * Examples:
 *
 *
 * Input: arr[] = {6, 1, 7, 2, 8, 4}
 *       transactionFee = 2
 * Output: 8 1
 *
 * Input: arr[] = {7, 1, 5, 3, 6, 4}
 *        transactionFee = 1
 * Output: 5 1
 */

public class MaxProfitByBuyAndSellStocks {

    private static void max_profit(int[] a, int fee) {
        Arrays.sort(a);
        int max_profit = 0, days = 0;
        for (int i = 0, j = a.length - 1; i < a.length / 2; i++, j--) {
            int profit = a[j] - a[i] - fee;
            if (profit > 0) {
                max_profit += profit;
                days++;
            }else{
                days--;
            }
        }
        System.out.println("Max Profit " + max_profit);
        System.out.println("Max Days " + days);
    }

    public static void main(String args[]) {
        max_profit(new int[]{1, 3, 2, 8, 4, 9}, 2);
        max_profit(new int[]{6, 1, 7, 2, 8, 4}, 2);
        max_profit(new int[]{7, 1, 5, 3, 6, 4}, 1);
    }
}
