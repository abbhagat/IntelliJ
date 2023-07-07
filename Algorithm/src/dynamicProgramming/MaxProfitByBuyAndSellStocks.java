package dynamicProgramming;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

/*
  Given an array of positive integers containing the price of stocks and transaction fee,
  the task is to find the maximum profit and the difference of days on which you are getting the maximum profit.
  Our task is to find the maximum profit under the following restrictions:
  we can’t buy a new stock if we have not sold the previous stock. that is at a time we can have at most one stock.
  we can do as many transactions as we want.
  Examples:
  Input: arr[] = {6, 1, 7, 2, 8, 4}
  transactionFee = 2
  Output: 8 1
  Input: arr[] = {7, 1, 5, 3, 6, 4}
  transactionFee = 1
  Output: 5 1
*/

// Time complexity:  O(n)
// Space complexity: O(1)
public class MaxProfitByBuyAndSellStocks {

    private static int maximumProfit(int[] a, int fee) {
        int buy = -a[0], sell = 0;
        for (int i = 1; i < a.length; i++) {
            int temp = buy;
            buy = max(buy, sell - a[i]);
            sell= max(sell, temp + a[i] - fee);
        }
        return max(buy, sell);
    }
/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
*/
    private static int maxProfit(int[] a) {
        int buy = Integer.MAX_VALUE, profit = 0;
        for (int x : a) {
            buy    = min(buy, x);
            profit = max(profit, x - buy);
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(maximumProfit(new int[]{1, 3, 2, 8, 4, 9}, 0));
        System.out.println(maximumProfit(new int[]{6, 1, 7, 2, 8, 4}, 0));
        System.out.println(maximumProfit(new int[]{7, 1, 5, 3, 6, 4}, 0));
        System.out.println(maximumProfit(new int[]{2, 7, 5, 9, 6, 4}, 0));
        System.out.println(maximumProfit(new int[]{7, 6, 4, 3, 1}, 0));
        System.out.println();
        System.out.println(maxProfit(new int[]{1, 3, 2, 8, 4, 9}));
        System.out.println(maxProfit(new int[]{6, 1, 7, 2, 8, 4}));
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{2, 7, 5, 9, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
