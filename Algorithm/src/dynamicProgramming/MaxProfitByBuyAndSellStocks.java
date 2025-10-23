package dynamicProgramming;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */

// Time complexity:  O(n)
// Space complexity: O(1)
public class MaxProfitByBuyAndSellStocks {

  private static int maxProfit(int[] a) {
    int buy = Integer.MAX_VALUE, profit = 0;
    for (int x : a) {
      buy = min(buy, x);
      profit = max(profit, x - buy);
    }
    return profit;
  }

  public static void main(String[] args) {
    System.out.println(maxProfit(new int[]{1, 3, 2, 8, 4, 9}));
    System.out.println(maxProfit(new int[]{6, 1, 7, 2, 8, 4}));
    System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    System.out.println(maxProfit(new int[]{2, 7, 5, 9, 6, 4}));
    System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
  }
}
