package geeks;

public class MinCostPathRecursion {

    private static int min(int x, int y, int z) {
        return x < y ? x < z ? x : z : y < z ? y : z;
    }

    private static int minCost(int[][] cost, int m, int n) {
        if (m < 0 || n < 0) {
            return Integer.MAX_VALUE;
        } else if (m == 0 && n == 0) {
            return cost[m][n];
        } else {
            return cost[m][n] + min(minCost(cost, m, n - 1), minCost(cost, m - 1, n - 1), minCost(cost, m - 1, n));
        }
    }

    public static void main(String[] args) {
        int cost[][] = { {1, 2, 3},
                         {4, 8, 2},
                         {1, 5, 3}
                       };
        System.out.print(minCost(cost, 2, 2));
    }
}
