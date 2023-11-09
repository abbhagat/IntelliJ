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
 * A[r, c] = A[r, c] + maximum of (A[r-1, c] and A[r, c-1]
 * return value of bottom right corner of A
 */

public class MaxGoldCollected {

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

    private static int maxGoldCollectedDP(int[][] a) {
        final int R = a.length, C = a[0].length;
        int[][] tc = new int[R][C];
        tc[0][0] = a[0][0];
        for (int i = 1; i < R; i++) {
            tc[i][0] = a[i][0] + tc[i - 1][0];
        }
        for (int j = 1; j < C; j++) {
            tc[0][j] = a[0][j] + tc[0][j - 1];
        }
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                tc[i][j] = a[i][j] + max(tc[i - 1][j], tc[i][j - 1]);
            }
        }
        return tc[R - 1][C - 1];
    }

    public static void main(String[] args) {
        List<List<Integer>> list = List.of(List.of(1, 4, 2, 2), List.of(6, 0, 0, 5));
        int R = list.size();
        int C = list.get(0).size();
        int[][] a = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                a[i][j] = list.get(i).get(j);
            }
        }
        System.out.println(maxGoldCollectedDP(a));
    }
}