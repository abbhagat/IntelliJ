package dynamicProgramming;

import java.util.List;

import static java.lang.Integer.max;

/**
 * Suppose we have a 2D matrix where each cell stores some coins. If we start from [0,0], and can only move right or down, we have to find the maximum number of coins we can collect by the bottom right corner.
 * <p>
 * So, if the input is like
 * <p>
 * 1  4  2  2
 * 0  0  0  5
 * then the output will be 14, as we take the path: [1, 4, 2, 2, 5]
 * <p>
 * To solve this, we will follow these steps−
 * <p>
 * for r in range 1 to row count of A, do
 * <p>
 * A[r, 0] := A[r, 0] + A[r-1, 0]
 * <p>
 * for c in range 1 to column count of A, do
 * <p>
 * A[0, c] := A[0, c] + A[0, c-1]
 * <p>
 * for r in range 1 to size of A, do
 * <p>
 * for c in range 1 to size of A[0], do
 * <p>
 * A[r, c] = A[r, c] + maximum of (A[r-1, c] and A[r, c-1]
 * <p>
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
        System.out.println(maxGoldCollected(a));
    }
}
