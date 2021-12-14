package binarySearchImpl;

import java.util.Arrays;

/**
 * Given an array a[] of N elements, which represent the positions of the cells in a prison.
 * Also, given an integer P which is the number of prisoners, the task is to place all the prisoners
 * in the cells in an ordered manner such that the minimum distance between any two prisoners is as large as possible.
 * Finally, print the maximized distance.
 * Examples:
 * Input: a[] = {1, 2, 4, 8, 9}, P = 3
 * Output: 3
 * The three prisoners will be placed at the cells numbered 1, 4 and 8 with the minimum distance 3 which is the maximum possible.
 * Input: a[] = {10, 12, 18}, P = 2
 * Output: 8
 * The three possible placements are {10, 12}, {10, 18} and {12, 18}.
 * Approach: This problem can be solved using binary search. As the minimum distance between two cells in which prisoners will be kept has to be maximized,
 * the search space will be of distance, starting from 0 (if two prisoners are kept in the same a) and ending at a[N – 1] – a[0]
 * (if one prisoner is kept in the first a, and the other one is kept in the last a).
 * Initialize L = 0 and R = a[N – 1] – a[0] then apply the binary search.
 * For every mid, check whther the prisoners can be placed such that the minimum distance between any two prisoners is at least mid
 * If yes then try to increase this distance in order to maximize the answer and check again.
 * If not then try to decrease the distance.
 * Finally, print the maximized distance.
 */

public class PlacePrisonerToMaxMinDiffBetweenAnyTwoPrisoner {

    private static boolean canPlace(int[] a, int n, int mid) {
        int prisoner_placed = a[0], numOfPrisonerPlaced = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] - prisoner_placed >= mid) {
                numOfPrisonerPlaced++;
                prisoner_placed = a[i];
                if (numOfPrisonerPlaced == n) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int maxDistance(int[] a, int n) {
        Arrays.sort(a);
        int low = 0, high = a[a.length - 1] - a[0], result = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canPlace(a, n, mid)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxDistance(new int[]{1, 2, 8, 4, 9}, 3));
    }
}
