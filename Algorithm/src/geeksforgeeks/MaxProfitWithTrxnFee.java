package geeksforgeeks;

import java.util.Arrays;

public class MaxProfitWithTrxnFee {

    private static void max_profit(int[] a, int fee) {
        Arrays.sort(a);
        int max_profit = 0, days = 0;
        for (int i = 0, j = a.length - 1; i < a.length / 2; i++, j--) {
            int profit = a[j] - a[i] - fee;
            if (profit > 0) {
                max_profit += profit;
            }
            days++;
        }
        System.out.println("Max Profit " + max_profit);
        System.out.println("Max Days " + days);
    }

    public static void main(String args[]) {
        max_profit(new int[]{1, 3, 2, 8, 4, 9}, 2);
    }
}
