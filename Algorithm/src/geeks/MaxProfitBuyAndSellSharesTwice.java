package geeks;


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

    public static void main(String[] args) {
        int[] a = {100, 30, 15, 10, 8, 25, 80};
        int buyVal = 0, sellVal = 0, i;
        for (i = 1; i < a.length; i++) {
            if (a[i] - a[i - 1] > 0) {
                buyVal = a[i - 1];
                sellVal = a[i];
                break;
            }
        }
        int profit = sellVal - buyVal;
        if (i == a.length) {
            System.out.println(profit);
        } else if (i + 1 == a.length - 1 && a[a.length - 1] > buyVal) {
            System.out.println(a[a.length - 1] - buyVal);
        } else {
            int max = a[i], min = a[i];
            for (int j = i; j < a.length; j++) {
                max = Math.max(max, a[j]);
                min = Math.min(min, a[j]);
            }
            profit += max - min;
            System.out.println(profit);
        }
    }
}
