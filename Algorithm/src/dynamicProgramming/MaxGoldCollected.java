package dynamicProgramming;

import java.util.List;

import static java.lang.Integer.max;

/**
 * Suppose we have a 2D matrix where each cell stores some coins.
 * If we start from [0,0], and can only move right or down,
 * we have to find the maximum number of coins we can collect by the bottom right corner.
 * So, if the input is like
 * 1  4  2  2
 * 0  0  0  5
 * then the output will be 14, as we take the path: [1, 4, 2, 2, 5]
 * To solve this, we will follow these steps−
 * for r in range 1 to row count of A, do
 * A[r, 0] := A[r, 0] + A[r-1, 0]
 * for c in range 1 to column count of A, do
 * A[0, c] := A[0, c] + A[0, c-1]
 * for r in range 1 to size of A, do
 * for c in range 1 to size of A[0], do
 * A[r, c] = A[r, c] + maximum of (A[r-1, c] and A[r, c-1] return value of bottom right corner of A
 */

public class MaxGoldCollected {

    // Time Complexity: O(2^(m+n))
    private static int maxGoldCollected(int[][] a, int m, int n, int R, int C) {
        if (m > R || n > C) {
            return Integer.MIN_VALUE;
        }
        if (m == R && n == C) {
            return a[m][n];
        }
        return a[m][n] + max(maxGoldCollected(a, m + 1, n, R, C), maxGoldCollected(a, m, n + 1, R, C));
    }

    private static int maxGoldCollected(int[][] a) {
        final int R = a.length, C = a[0].length;
        for (int i = 1; i < R; i++) {
            a[i][0] += a[i - 1][0];
        }
        for (int j = 1; j < C; j++) {
            a[0][j] += a[0][j - 1];
        }
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                a[i][j] += max(a[i - 1][j], a[i][j - 1]);
            }
        }
        return a[R - 1][C - 1];
    }

    private static int maxGoldCollectedDP(int[][] cost) {
        final int m = cost.length, n = cost[0].length;
        int[][] tc = new int[m][n];
        tc[0][0] = cost[0][0];
        for (int i = 1; i < m; i++) {
            tc[i][0] = cost[i][0] + tc[i - 1][0];
        }
        for (int j = 1; j < n; j++) {
            tc[0][j] = cost[0][j] + tc[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                tc[i][j] = cost[i][j] + max(tc[i - 1][j], tc[i][j - 1]);
            }
        }
        return tc[m - 1][n - 1];
    }

    public static void main(String[] args) {
        List<List<Integer>> listofList = List.of(List.of(1, 4, 2, 2), List.of(6, 0, 0, 5));
        int[][] a = listofList.stream()
                .map(l -> l.stream()
                        .mapToInt(Integer::intValue)
                        .toArray())
                .toArray(int[][]::new);
        System.out.println(maxGoldCollected(a, 0, 0, a.length - 1, a[0].length - 1) + "\t" + maxGoldCollectedDP(a) + "\t" + maxGoldCollected(a));
    }
}
