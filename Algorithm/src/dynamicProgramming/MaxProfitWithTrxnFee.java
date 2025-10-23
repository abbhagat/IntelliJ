package dynamicProgramming;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day,
 * and an integer fee representing a transaction fee.
 * Find the maximum profit you can achieve. You may complete as many transactions as you like,
 * but you need to pay the transaction fee for each transaction.
 * <p>
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * The transaction fee is only charged once for each stock purchase and sale.
 * <p>
 * Example 1:  Input: prices = [1,3,2,8,4,9], fee = 2 Output: 8
 * Explanation: The maximum profit can be achieved by:
 * - Buying  at prices[0] = 1
 * - Selling at prices[3] = 8
 * - Buying  at prices[4] = 4
 * - Selling at prices[5] = 9
 * The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * <p>
 * Example 2:  Input: prices = [1,3,7,5,10,3], fee = 3 Output: 6
 */

public class MaxProfitWithTrxnFee {

  public static int maxProfit(int[] a, int fee) {
    int buy = Integer.MAX_VALUE, profit = 0;
    for (int x : a) {
      buy = min(buy, x - profit);
      profit = max(profit, x - buy - fee);
    }
    return profit;
  }

  public static void main(String[] args) {
    System.out.println(maxProfit(new int[]{6, 1, 7, 2, 8, 4}, 2));
    System.out.println(maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    System.out.println(maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3));
  }
}
