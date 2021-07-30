package geeks;

import java.util.Arrays;

/**
 * Given an array cell[] of N elements, which represent the positions of the cells in a prison.
 * Also, given an integer P which is the number of prisoners, the task is to place all the prisoners
 * in the cells in an ordered manner such that the minimum distance between any two prisoners is as large as possible.
 * Finally, print the maximized distance.
 * Examples:
 * Input: cell[] = {1, 2, 4, 8, 9}, P = 3
 * Output: 3
 * The three prisoners will be placed at the cells numbered 1, 4 and 8 with the minimum distance 3 which is the maximum possible.
 * Input: cell[] = {10, 12, 18}, P = 2
 * Output: 8
 * The three possible placements are {10, 12}, {10, 18} and {12, 18}.
 * Approach: This problem can be solved using binary search. As the minimum distance between two cells in which prisoners will be kept has to be maximized,
 * the search space will be of distance, starting from 0 (if two prisoners are kept in the same cell) and ending at cell[N – 1] – cell[0]
 * (if one prisoner is kept in the first cell, and the other one is kept in the last cell).
 * Initialize L = 0 and R = cell[N – 1] – cell[0] then apply the binary search.
 * For every mid, check whther the prisoners can be placed such that the minimum distance between any two prisoners is at least mid
 * If yes then try to increase this distance in order to maximize the answer and check again.
 * If not then try to decrease the distance.
 * Finally, print the maximized distance.
 */

public class PlacePrisonerToMaxMinDiffBetweenAnyTwoPrisoner {

    private static boolean canPlace(int[] a, int p, int sep) {
        int prisoners_placed = 1;         // Considering the first prisoner is placed at 1st cell
        // If the first prisoner is placed at the first cell then the last_prisoner_placed will be the first prisoner placed and that will be in cell[0]
        int last_prisoner_placed = a[0];
        for (int i = 1; i < a.length; i++) {
            int current_cell = a[i];
            if (current_cell - last_prisoner_placed >= sep) {  // Checking if the prisoner can be placed at ith cell or not
                prisoners_placed++;
                last_prisoner_placed = current_cell;
                if (prisoners_placed == p) {                  // If all the prisoners got placed then return true
                    return true;
                }
            }
        }
        return false;
    }

    private static int maxDistance(int cell[], int p) {
        Arrays.sort(cell);                     // Sort the array so that binary search can be applied on it
        int start = 0;                        // Minimum possible distance for the search space
        int end = cell[cell.length - 1] - cell[0];     // Maximum possible distance for the search space
        int ans = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            // If the prisoners can be placed such that the minimum distance between any two prisoners is at least mid
            if (canPlace(cell, p, mid)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxDistance(new int[]{1, 2, 8, 4, 9}, 3));
    }
}
