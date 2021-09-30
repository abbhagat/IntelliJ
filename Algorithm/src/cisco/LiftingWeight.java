package cisco;

public class LiftingWeight {

    public static void main(String[] args) {
        int W = 7;
        int[] wt = {1, 3, 5};
        int n = wt.length - 1;
        System.out.println(knapSack(W, wt, n));
    }

    private static int knapSack(int W, int[] wt, int n) {
        if (n + 1 == 0 || W == 0) {
            return 0;
        }
        if (wt[n] > W) {
            return knapSack(W, wt, n - 1);
        }
        return Math.max(wt[n] + knapSack(W - wt[n], wt, n - 1), knapSack(W, wt, n - 1));
    }
}
