package geeksforgeeks;

public class MaxProfitWithTrxnFee {

    static int max_profit(int a[], int b[], int n, int fee) {
        int i, j, profit;
        int l, r, diff_day = 1, sum = 0;
        b[0] = 0;                  //b[0] will contain the maximum profit
        b[1] = diff_day;          //b[1] will contain the day on which we are getting the maximum profit
        for (i = 1; i < n; i++) {
            l = 0;
            r = diff_day;
            sum = 0;
            for (j = n - 1; j >= i; j--) {
                profit = (a[r] - a[l]) - fee;   //here finding the max profit
                if (profit > 0) {
                    sum = sum + profit;
                }
                l++;
                r++;
            }
            if (b[0] < sum) {  //check if sum is greater then maximum then store the new maximum
                b[0] = sum;
                b[1] = diff_day;
            }
            diff_day++;
        }
        return 0;
    }

    public static void main(String args[]) {
        int arr[] = {1, 3, 2, 8, 4, 9};
        int n = arr.length;
        int[] b = new int[2];
        int tranFee = 2;
        max_profit(arr, b, n, tranFee);
        System.out.println(b[0] + ", " + b[1]);
    }
}
