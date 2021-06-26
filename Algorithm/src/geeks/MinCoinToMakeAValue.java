package geeks;

public class MinCoinToMakeAValue {

    static int minCoins(int coins[], int n, int V) {
        if (V == 0) {  // base case
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {  // Try every coin that has smaller value than V
            if (coins[i] <= V) {
                int sub_res = minCoins(coins, n, V - coins[i]);
                if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res)  // Check for INT_MAX to avoid overflow and see if result can minimized
                    res = sub_res + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int coins[] = {9, 6, 5, 1};
        int n = coins.length;
        int V = 11;
        System.out.println("Minimum coins required is " + minCoins(coins, n, V));
    }
}
