package dynamicProgramming;


import static java.lang.Integer.max;

public class CuttingRodProblem {

    private static int cutRod(int[] price, int n) {
        if (n == 0) {
            return 0;
        }
        int max_val = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max_val = max(max_val, price[i] + cutRod(price, n - i - 1));
        }
        return max_val;
    }

    public static void main(String[] args) {
        int[] price = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(cutRod(price, price.length));
        price = new int[]{1, 2, 3, 4, 5};
        System.out.println(cutRod(price, price.length));
    }
}
