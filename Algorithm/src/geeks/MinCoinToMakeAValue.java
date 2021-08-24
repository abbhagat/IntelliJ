package geeks;

public class MinCoinToMakeAValue {

    private static int minCoins(int coins[], int value) {
        if (value == 0) {
            return 0;
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= value) {
                int min = minCoins(coins, value - coins[i]);
                result = min < result ? min + 1 : result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Minimum coins required is " + minCoins(new int[]{9, 6, 5, 1}, 11));
        System.out.println("Minimum coins required is " + minCoins(new int[]{25, 10, 5}, 30));
        System.out.println("Minimum coins required is " + minCoins(new int[]{9, 6, 5, 1}, 21));
    }
}
