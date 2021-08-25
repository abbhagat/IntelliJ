package geeks;

public class MinCoinToMakeAValue {

    private static int minCoins(int coins[], int value) {
        if (value == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= value) {
                int result = minCoins(coins, value - coins[i]);
                min = result < min ? result : min;
            }
        }
        return min + 1;
    }

    public static void main(String[] args) {
        System.out.println("Minimum coins required is " + minCoins(new int[]{9, 6, 5, 1}, 11));
        System.out.println("Minimum coins required is " + minCoins(new int[]{25, 10, 5}, 30));
        System.out.println("Minimum coins required is " + minCoins(new int[]{9, 6, 5, 1}, 21));
    }
}
