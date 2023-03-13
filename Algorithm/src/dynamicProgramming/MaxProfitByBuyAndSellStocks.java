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

    private static void maxProfitWithTrxnFee(int[] a, int fee) {
        int buying = 0, selling = -a[0], diff_days = 1;
        for (int i = 1; i < a.length; i++) {
            buying = max(buying, selling + a[i] - fee);
            selling= max(selling, buying - a[i]);
            if (selling > buying) {
                diff_days++;
            }
        }
        System.out.println(buying + " " + diff_days);
    }

    private static int maxProfit(int[] a) {
        int minVal = Integer.MAX_VALUE, profit = 0;
        for (int x : a) {
            minVal = min(minVal, x);
            profit = max(profit, x - minVal);
        }
        return profit;
    }

    public static void main(String[] args) {
        maxProfit(new int[]{1, 3, 2, 8, 4, 9});
        maxProfit(new int[]{6, 1, 7, 2, 8, 4});
        maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        maxProfit(new int[]{7, 6, 4, 3, 1});
    }
}
