package binarySearchImpl;

import java.util.Arrays;

/**
 * Given an array a[] of N elements, which represent the positions of the cells in a prison.
 * Also, given an integer P which is the number of prisoners, the task is to place all the prisoners
 * in the cells in an ordered manner such that the minimum distance between any two prisoners is as large as possible.
 * Finally, print the maximized distance.
 * Examples:
 * Input: a[] = {1, 2, 4, 8, 9}, P = 3 Output: 3
 * The three prisoners will be placed at the cells numbered 1, 4 and 8 with the minimum distance 3 which is the maximum possible.
 * Input: a[] = {10, 12, 18}, P = 2 Output: 8
 * The three possible placements are {10, 12}, {10, 18} and {12, 18}.
 */

// Time Complexity: O(n * log n)
public class PlacePrisonerToMaxMinDiffBetweenAnyTwoPrisoner {

  private static boolean canPlace(int[] a, int p, int mid) {
    int prisonerPlaced = a[0], numOfPrisonerPlaced = 1;
    for (int i = 1; i < a.length; i++) {
      if (a[i] - prisonerPlaced >= mid) {
        numOfPrisonerPlaced++;
        prisonerPlaced = a[i];
        if (numOfPrisonerPlaced == p) {
          return true;
        }
      }
    }
    return false;
  }

  private static int maxDistance(int[] a, int p) {
    Arrays.sort(a);
    int low = 0, high = a[a.length - 1] - a[0], result = 0;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (canPlace(a, p, mid)) {
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
    System.out.println(maxDistance(new int[]{10, 12, 18}, 2));
  }
}
