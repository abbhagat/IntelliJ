package dynamicProgramming;


import static java.lang.Integer.max;

/**
 * In daily share trading, a buyer buys shares in the morning and sells them on the same day.
 * If the trader is allowed to make at most 2 transactions in a day,
 * whereas the second transaction can only start after the first one is complete (Sell->buy->sell->buy).
 * Given stock prices throughout the day, find out the maximum profit that a share trader could have made.
 * <p>
 * Examples:
 * <p>
 * Input:   price[] = {10, 22, 5, 75, 65, 80};
 * Output:  87
 * Trader earns 87 as sum of 12, 75
 * Buy at 10, sell at 22,
 * Buy at 5 and sell at 80
 * <p>
 * Input:   price[] = {2, 30, 15, 10, 8, 25, 80};
 * Output:  100
 * Trader earns 100 as sum of 28 and 72
 * Buy at price 2, sell at 30, buy at 8 and sell at 80
 * <p>
 * Input:   price[] = {100, 30, 15, 10, 8, 25, 80};
 * Output:  72
 * Buy at price 8 and sell at 80.
 * <p>
 * Input:   price[] = {90, 80, 70, 60, 50};
 * Output:  0
 * Not possible to earn.
 */
public class MaxProfitBuyAndSellSharesTwice {

    private static int maxProfit(int[] a) {
        int first_buy  = Integer.MIN_VALUE, first_sell  = 0;
        int second_buy = Integer.MIN_VALUE, second_sell = 0;
        for (int x : a) {
            first_buy   = max(first_buy, -x);
            first_sell  = max(first_sell, first_buy  + x);
            second_buy  = max(second_buy, first_sell - x);
            second_sell = max(second_sell,second_buy + x);
        }
        return second_sell;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{10, 22, 5, 75, 65, 80}));
        System.out.println(maxProfit(new int[]{100, 30, 15, 10, 8, 25, 80}));
        System.out.println(maxProfit(new int[]{2, 30, 15, 10, 8, 25, 80}));
        System.out.println(maxProfit(new int[]{90, 80, 70, 60, 50}));
    }
}
