package dynamicProgramming;

// Time Complexity: O(n*k^2)

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class EggDroppingPuzzleDP {

    private static int eggDropDP(int eggs, int floors) {
        int[][] dp = new int[eggs + 1][floors + 1];
        for (int i = 1; i <= eggs; i++) {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }
        for (int i = 1; i <= floors; i++) {
            dp[1][i] = i;
        }

        for (int i = 2; i <= eggs; i++) {
            for (int j = 2; j <= floors; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 1; k <= j; k++) {
                    int result = 1 + max(dp[i - 1][k - 1], dp[i][j - k]);
                    dp[i][j] = min(dp[i][j], result);
                }
            }
        }
        return dp[eggs][floors];
    }

    public static void main(String args[]) {
        System.out.println("Minimum number of trials " + eggDropDP(2, 10));
        System.out.println("Minimum number of trials " + eggDropDP(2, 36));
    }
}
