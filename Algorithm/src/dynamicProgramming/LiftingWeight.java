package dynamicProgramming;

import static java.lang.Integer.max;

public class LiftingWeight {

    public static void main(String[] args) {
        int W = 7;
        int[] wt = {1, 3, 5};
        int n = wt.length - 1;
        System.out.println(knapSack(W, wt, n));
        System.out.println(cutRod(W, wt, n));
    }

    private static int knapSack(int W, int[] wt, int n) {
        if (n + 1 == 0 || W == 0) {
            return 0;
        }
        if (wt[n] > W) {
            return knapSack(W, wt, n - 1);
        }
        return max(wt[n] + knapSack(W - wt[n], wt, n - 1), knapSack(W, wt, n - 1));
    }

    private static int cutRod(int W, int[] wt, int n) {
        if (n == 0 || W == 0) {
            return 0;
        }
        int maxVal = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            maxVal = max(maxVal, cutRod(W, wt, n - i - 1) + wt[i]);
        }
        return maxVal;
    }
}
