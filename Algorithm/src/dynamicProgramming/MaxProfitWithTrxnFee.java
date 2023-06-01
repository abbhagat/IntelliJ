package dynamicProgramming;

public class MaxProfitWithTrxnFee {

    private static void maxProfit(int[] a, int[] b, int fee) {
        int diff_day = 1;
        b[0] = 0;          //b[0] will contain the maximum profit
        b[1] = diff_day;  //b[1] will contain the day on which we are getting the maximum profit
        for (int i = 1; i < a.length; i++) {
            int l = 0, r = diff_day, sum = 0;
            for (int j = a.length - 1; j >= i; j--) {
                int profit = (a[r] - a[l]) - fee;  //here finding the max profit if we get less then or equal to zero it means we are not getting the profit
                if (profit > 0) {
                    sum = sum + profit;
                }
                l++;
                r++;
            }
            if (b[0] < sum) {  //check if sum is greater than maximum then store the new maximum
                b[0] = sum;
                b[1] = diff_day;
            }
            diff_day++;
        }
    }

    public static void main(String args[]) {
        int[] a = {6, 1, 7, 2, 8, 4};
        int[] b = new int[2];
        maxProfit(a, b, 2);
        System.out.println(b[0] + ", " + b[1]);
    }
}
