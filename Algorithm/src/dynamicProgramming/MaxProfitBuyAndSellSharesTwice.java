package dynamicProgramming;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

/**
 * In daily share trading, a buyer buys shares in the morning and sells them on the same day.
 * If the trader is allowed to make at most 2 transactions in a day,
 * whereas the second transaction can only start after the first one is complete (Sell->buy->sell->buy).
 * Given stock prices throughout the day, find out the maximum profit that a share trader could have made.
 * Examples:
 * Input: price[] = {10, 22, 5, 75, 65, 80}; Output: 87
 * Trader earns 87 as a sum of 12, 75
 * Buy at 10, sell at 22,
 * Buy at 5 and sell at 80
 * Input: price[] = {2, 30, 15, 10, 8, 25, 80}; Output:  100
 * Trader earns 100 as a sum of 28 and 72
 * Buy at price 2, sell at 30, buy at 8 and sell at 80
 * Input: price[] = {100, 30, 15, 10, 8, 25, 80}; Output: 72
 * Buy at price 8 and sell at 80.
 * Input:   price[] = {90, 80, 70, 60, 50}; Output:  0
 * Not possible to earn.
 * Input: prices[] = {3, 3, 5, 0, 0, 3, 1, 4} Output: 6
 * Explanation:
 * Buy on Day 4 and Sell at Day 6 => Profit = 3 – 0 = 3
 * Buy on Day 7 and Sell at Day 8 => Profit = 4 -1 = 3
 * Therefore, Total Profit = 3 + 3 = 6
 * Input: prices[] = {1, 2, 3, 4, 5} Output: 4
 * Explanation:
 * Buy on Day 1 and sell at Day 6 => Profit = 5-1 = 4
 * Therefore, Total Profit = 4
 */
public class MaxProfitBuyAndSellSharesTwice {

  private static int maxProfit(int[] price) {
    int buy1 = Integer.MAX_VALUE, buy2 = Integer.MAX_VALUE, profit1 = 0, profit2 = 0;
    for (int x : price) {
      buy1 = min(buy1, x);
      profit1 = max(profit1, x - buy1);
      buy2 = min(buy2, x - profit1);
      profit2 = max(profit2, x - buy2);
    }
    return profit2;
  }

  public static void main(String[] args) {
    System.out.println(maxProfit(new int[]{10, 22, 5, 75, 65, 80}));
    System.out.println(maxProfit(new int[]{100, 30, 15, 10, 8, 25, 80}));
    System.out.println(maxProfit(new int[]{2, 30, 15, 10, 8, 25, 80}));
    System.out.println(maxProfit(new int[]{90, 80, 70, 60, 50}));
    System.out.println(maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    System.out.println(maxProfit(new int[]{1, 2, 3, 4, 5}));
  }
}
