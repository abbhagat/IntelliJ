package geeks;


/**
 * Given a rod of length n inches and an array of prices that includes prices of all pieces of size smaller than n.
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces.
 * For example, if the length of the rod is 8 and the values of different pieces are given as the following,
 * then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
 * length   | 1   2   3   4   5   6   7   8
 * --------------------------------------------
 * price    | 1   5   8   9  10  17  17  20
 * And if the prices are as following, then the maximum obtainable value is 24 (by cutting in eight pieces of length 1)
 * length   | 1   2   3   4   5   6   7   8
 * --------------------------------------------
 * price    | 3   5   8   9  10  17  17  20
 * <p>
 * 1) Optimal Substructure:
 * We can get the best price by making a cut at different positions and comparing the values obtained after a cut.
 * We can recursively call the same function for a piece obtained after a cut.
 * Let cutRod(n) be the required (best possible price) value for a rod of length n. cutRod(n) can be written as follows.
 * cutRod(n) = max(price[i] + cutRod(n-i-1)) for all i in {0, 1 .. n-1}
 */

public class CuttingRodProblem {

    private static int cutRod(int[] price, int n) {
        if (n == 0) {
            return 0;
        }
        int max_val = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {  // Recursively cut the rod in different pieces and compare different configurations
            max_val = Math.max(max_val, price[i] + cutRod(price, n - i - 1));
        }
        return max_val;
    }

    public static void main(String args[]) {
        int price[] = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println("Maximum Obtainable Value is " + cutRod(price, price.length));
    }
}
