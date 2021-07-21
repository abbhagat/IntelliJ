package leetcode;

/**
 * You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.
 * A pair (c, d) can follow another pair (a, b) if b < c. Chain of pairs can be formed in this fashion.
 * Find the longest chain which can be formed from a given set of pairs.
 * For example, if the given pairs are {{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90} },
 * then the longest chain that can be formed is of length 3, and the chain is {{5, 24}, {27, 40}, {50, 90}}

 * Recommended: Please solve it on “PRACTICE” first, before moving on to the solution.
 * This problem is a variation of standard Longest Increasing Subsequence problem. Following is a simple two step process.
 * 1) Sort given pairs in increasing order of first (or smaller) element. Why do not need sorting?
 * Consider the example {{6, 8}, {3, 4}} to understand the need of sorting.
 * If we proceed to second step without sorting, we get output as 1. But the correct output is 2.
 * 2) Now run a modified LIS process where we compare the second element of already
 * finalized LIS with the first element of new LIS being constructed.
 */

class Pair {
    int a;
    int b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

public class MaxLengthChainPairs {

    private static int maxChainLength(Pair pair[], int n) {
        int mcl[] = new int[n];
        for (int i = 0; i < n; i++) {      // Initialize MCL (max chain length) values for all indexes
            mcl[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pair[i].a > pair[j].b && mcl[i] < mcl[j] + 1) {
                    mcl[i] = mcl[j] + 1;
                }
            }
        }
        // mcl[i] now stores the maximum chain length ending with pair i
        int max = 0;
        for (int x : mcl) {                    // Pick maximum of all MCL values
            max = Math.max(max, x);
        }
        return max;
    }

    public static void main(String[] args) {
        Pair[] pair = new Pair[]
                {
                        new Pair(5, 24),
                        new Pair(15, 25),
                        new Pair(27, 40),
                        new Pair(50, 60)};
        System.out.println("Length of maximum size chain is " + maxChainLength(pair, pair.length));
    }
}
