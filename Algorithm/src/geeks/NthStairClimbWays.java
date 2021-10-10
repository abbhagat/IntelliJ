package geeks;

/*
There are n stairs, a person standing at the bottom wants to reach the top.
The person can climb either 1 stair or 2 stairs at a time.
Count the number of ways, the person can reach the top.
ways(n) = ways(n-1) + ways(n-2)
 */
public class NthStairClimbWays {

    public static void main(String[] args) {
        System.out.println(stairCount(4));
        System.out.println(stairCountDP(4));
    }

    private static int stairCountDP(int n) {
        int[] dp = new int[n + 1];
        if (n == 1) {
            dp[1] = 1;
        }
        if (n >= 2) {
            dp[1] = 1;
            dp[2] = 2;
        }
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    private static int stairCount(int n) {
        switch (n) {
            case 1:
                return 1;
            case 2:
                return 2;
            default:
                return stairCount(n - 1) + stairCount(n - 2);
        }
    }
}
