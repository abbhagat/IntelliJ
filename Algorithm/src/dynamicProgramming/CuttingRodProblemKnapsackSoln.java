package dynamicProgramming;

import static java.lang.Integer.max;

// Time Complexity: O(n^2)
// Auxiliary Space: O(n^2)
public class CuttingRodProblemKnapsackSoln {

    public static void main(String[] args) {
        int[] price = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        int[] wt = new int[price.length];
        for (int i = 0; i < wt.length; i++) {
            wt[i] = i + 1;
        }
        int W = wt.length;
        int maxVal = cuttingRodSoln(W, wt, price, price.length - 1);
        System.out.println(maxVal);
    }

    private static int cuttingRodSoln(int W, int[] wt, int[] price, int n) {
        int[] dp = new int[W + 1];
        for (int i = 0; i <= W; i++) {
            for (int j = 0; j <= n; j++) {
                if (i >= wt[j]) {
                    dp[i] = max(dp[i], dp[i - wt[j]] + price[j]);
                }
            }
        }
        return dp[W];
    }
}
