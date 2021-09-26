package geeksforgeeks;

import static java.lang.Integer.max;

public class MaxProfitWithTrxnFee {

    private static int max_profit(int[] a, int fee) {
        int buying = 0, selling = -a[0];
        for (int i = 1; i < a.length; i++) {
            buying  = max(buying, selling + a[i] - fee);
            selling = max(selling, buying - a[i]);
        }
        return buying;
    }

    public static void main(String args[]) {
        System.out.println(max_profit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }
}
