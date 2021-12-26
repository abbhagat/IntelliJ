package dynamicProgramming;

/*
  Given a knapsack weight W and a set of n items with certain value val i and weight wt i,
  we need to calculate the maximum amount that could make up this quantity exactly.
  Input : W = 100
  val[]  = {1, 30}
  wt[] = {1, 50}
  Output : 100
  There are many ways to fill knapsack.
  1) 2 instances of 50 unit weight item.
  2) 100 instances of 1 unit weight item.
  3) 1 instance of 50 unit weight item and 50
  instances of 1 unit weight items.
  We get maximum value with option 2.
  Input : W = 8
  val[] = {10, 40, 50, 70}
  wt[]  = {1, 3, 4, 5}
  Output : 110
  We get maximum value with one unit of
  weight 5 and one unit of weight 3.
  Its an unbounded knapsack problem as we can use 1 or more instances of any resource.
  A simple 1D array, say dp[W+1] can be used such that dp[i] stores the maximum value which can achieved using all items and i capacity of knapsack.
  Note that we use 1D array here which is different from classical knapsack where we used 2D array. Here number of items never changes.
  We always have all items available.
  We can recursively compute dp[] using below formula
  dp[i] = 0
  dp[i] = max(dp[i], dp[i-wt[j]] + val[j] where j varies from 0 to n-1 such that wt[j] <= i
  result = d[W]
 */
public class ZeroOneKnapSackUnboundedDP {

    private static int unboundedKnapsack(int W, int[] wt, int[] val, int n) {
        int dp[] = new int[W + 1];
        for (int i = 0; i <= W; i++) {
            for (int j = 0; j <= n; j++) {
                if (wt[j] <= i) {
                    dp[i] = Math.max(dp[i], dp[i - wt[j]] + val[j]);
                }
            }
        }
        return dp[W];
    }

    public static void main(String[] args) {
        int W = 8;
        int[] val = {10, 40, 50, 70};
        int[] wt = {1, 3, 4, 5};
        int n = val.length - 1;
        System.out.println(unboundedKnapsack(W, wt, val, n));
    }
}
