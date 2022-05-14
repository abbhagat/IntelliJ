package cisco;

import static java.lang.Integer.min;

public class PaintHouse {

    private static int minCost(int[][] cost) {
        int n = cost.length;
        if (n == 0) {
            return 0;
        }
        for (int i = 1; i < n; i++) {
            cost[i][0] = min(cost[i - 1][1], cost[i - 1][2]);
            cost[i][1] = min(cost[i - 1][0], cost[i - 1][2]);
            cost[i][2] = min(cost[i - 1][1], cost[i - 1][0]);
        }
        return min(min(cost[n - 1][0], cost[n - 1][1]), cost[n - 1][2]);
    }

    public static void main(String[] args) {
        int[][] cost = {
                         {17, 2, 17},
                         {16, 16, 5},
                         {14, 3, 19}
                       };
        System.out.println(minCost(cost));
    }
}
