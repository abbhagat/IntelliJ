package geeks;

public class MinCoinToMakeAValue {

    // Time Complexity Exponential Has Overlapping Sub problems
    private static int minCoins(int coins[], int value) {
        if (value == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= value) {
                int result = minCoins(coins, value - coins[i]);
                min = Math.min(min, result);
            }
        }
        return min + 1;
    }

    // Time Complexity (mV)
    private static int minCoinsDP(int coins[], int V) {
        int dp[] = new int[V + 1];
        dp[0] = 0;                                        // Base case (If given value value is 0)
        for (int i = 1; i <= V; i++) {
            dp[i] = Integer.MAX_VALUE;                  // Initialize all dp values as Infinite
        }
        for (int i = 1; i <= V; i++) {                // Compute minimum coins required for all values from 1 to value
            for (int j = 0; j < coins.length; j++)   // Go through all coins smaller than i
                if (coins[j] <= i) {
                    int result = dp[i - coins[j]];
                    if (result != Integer.MAX_VALUE && result + 1 < dp[i])
                        dp[i] = result + 1;
                }
        }
        if (dp[V] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[V];
    }

    public static void main(String[] args) {
        System.out.println("Minimum coins required is " + minCoins(new int[]{9, 6, 5, 1}, 11));
        System.out.println("Minimum coins required is " + minCoins(new int[]{25, 10, 5}, 30));
        System.out.println("Minimum coins required is " + minCoins(new int[]{9, 6, 5, 1}, 21));
        System.out.println("Minimum coins required is " + minCoinsDP(new int[]{9, 6, 5, 1}, 11));
        System.out.println("Minimum coins required is " + minCoinsDP(new int[]{25, 10, 5}, 30));
        System.out.println("Minimum coins required is " + minCoinsDP(new int[]{9, 6, 5, 1}, 21));
    }
}
