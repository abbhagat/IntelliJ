package geeks;

import static java.lang.Integer.max;

/**
 * Given an array of positive integers containing the price of stocks and transaction fee,
 * the task is to find the maximum profit and the difference of days on which you are getting the maximum profit.
 * Examples:
 * <p>
 * <p>
 * Input: arr[] = {6, 1, 7, 2, 8, 4}
 * transactionFee = 2
 * Output: 8 1
 * <p>
 * Input: arr[] = {7, 1, 5, 3, 6, 4}
 * transactionFee = 1
 * Output: 5 1
 */

public class MaxProfitByBuyAndSellStocks {

    private static void max_profit(int[] a, int fee) {
        int buying = 0, selling = -a[0];
        for (int i = 1; i < a.length; i++) {
            buying =  max(buying, selling + a[i] - fee);
            selling = max(selling, buying - a[i]);
        }
        System.out.println(buying);
    }

    public static void main(String args[]) {
        max_profit(new int[]{1, 3, 2, 8, 4, 9}, 2);
        max_profit(new int[]{6, 1, 7, 2, 8, 4}, 2);
        max_profit(new int[]{7, 1, 5, 3, 6, 4}, 1);
    }
}
