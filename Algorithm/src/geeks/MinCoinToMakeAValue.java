package geeks;

public class MinCoinToMakeAValue {

    static int minCoins(int coins[], int n, int value) {
        if (value == 0) {
            return 0;
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {  // Try every coin that has smaller value than value
            if (coins[i] <= value) {
                int sub_result = minCoins(coins, n, value - coins[i]);
                if (sub_result != Integer.MAX_VALUE && sub_result + 1 < result)  // Check for INT_MAX to avoid overflow and see if result can minimized
                    result = sub_result + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int coins[] = {9, 6, 5, 1};
        int n = coins.length;
        int value = 11;
        System.out.println("Minimum coins required is " + minCoins(coins, n, value));
    }
}
