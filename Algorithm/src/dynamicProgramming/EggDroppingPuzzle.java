package dynamicProgramming;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class EggDroppingPuzzle {

    private static int eggDrop(int eggs, int floor) {
        if (floor == 0 || floor == 1) {
            return floor;
        }
        if (eggs == 1) {
            return floor;
        }
        int mid = (floor + 1) / 2;
        return 1 + (floor - mid > mid - 1 ? eggDrop(eggs, floor - mid) : eggDrop(eggs - 1, mid - 1));
    }

    // Time Complexity: O(n*k^2)
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
        System.out.println(eggDrop(2, 10)  + "\t" + eggDropDP(2, 10));
        System.out.println(eggDrop(2, 36)  + "\t" + eggDropDP(2, 36));
        System.out.println(eggDrop(2, 100) + "\t" + eggDropDP(2, 100));
    }
}
