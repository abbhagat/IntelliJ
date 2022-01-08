package recursion;

public class MinCostPathRecursion {

    private static int min(int x, int y, int z) {
        return Math.min(x, Math.min(y, z));
    }

    private static int minCost(int[][] cost, int m, int n) {
        if (m < 0 || n < 0) {
            return Integer.MAX_VALUE;
        }
        if (m == 0 && n == 0) {
            return cost[m][n];
        }
        return cost[m][n] + min(minCost(cost, m, n - 1), minCost(cost, m - 1, n - 1), minCost(cost, m - 1, n));
    }

    public static void main(String[] args) {
        int cost[][] = {
                {1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}
        };
        System.out.print(minCost(cost, 2, 2));
    }
}
