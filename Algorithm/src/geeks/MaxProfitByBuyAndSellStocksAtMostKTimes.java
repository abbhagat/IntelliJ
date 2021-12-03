package geeks;


/*
  for (int i = 0; i <= k; i++) {    // For day 0, you can't earn money irrespective of how many times you trade
         profit[i][0] = 0;
  }
  for (int i = 0; i <= n; i++) {  // profit is 0 if we don't do any transaction (i.e. k =0)
        profit[0][i] = 0;
  }
 */

import static java.lang.Integer.max;

public class MaxProfitByBuyAndSellStocksAtMostKTimes {

    private static int maxProfit(int[] price, int n, int k) {
        int[][] profit = new int[k + 1][n + 1];
        for (int i = 1; i <= k; i++) {
            int prevDiff = Integer.MIN_VALUE;
            for (int j = 1; j <= n; j++) {
                prevDiff     = max(prevDiff, profit[i - 1][j - 1] - price[j - 1]);
                profit[i][j] = max(profit[i][j - 1], price[j] + prevDiff);
            }
        }
        return profit[k][n];
    }

    public static void main(String[] args) {
        int[] price = {100, 30, 15, 10, 8, 25, 80};
        System.out.println("Maximum profit is: " + maxProfit(price, price.length - 1, 2));
        price = new int[]{90, 80, 70, 60, 50};
        System.out.println("Maximum profit is: " + maxProfit(price, price.length - 1, 2));
        price = new int[]{2, 30, 15, 10, 8, 25, 80};
        System.out.println("Maximum profit is: " + maxProfit(price, price.length - 1, 2));
        price = new int[]{10, 22, 5, 75, 65, 80};
        System.out.println("Maximum profit is: " + maxProfit(price, price.length - 1, 2));
    }
}
