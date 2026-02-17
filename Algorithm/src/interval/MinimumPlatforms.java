package interval;

import java.util.Arrays;
import static java.lang.Integer.max;

/**
 * Arrival   = [900, 940, 950, 1100, 1500, 1800]
 * Departure = [910, 1200, 1120, 1130, 1900, 2000]
 * Output = 3
 */

public class MinimumPlatforms {

  public static int minPlatforms(int[] arr, int[] dep) {
    Arrays.sort(arr);
    Arrays.sort(dep);
    int platforms = 1;   // current platforms needed
    int max = 1;         // maximum platforms needed
    int i = 1, j = 0;
    while (i < arr.length && j < dep.length) {
      if (arr[i] <= dep[j]) {
        platforms++;    // new train arrives
        i++;
      } else {
        platforms--;    // train departs
        j++;
      }
      max = max(max, platforms);
    }
    return max;
  }

  private static int minPlatforms(int[][] a) {
    Arrays.sort(a, (x, y) -> x[0] - y[0]);  // Comparator.comparingInt(x -> x[0])
    Arrays.sort(a, (x, y) -> x[1] - y[1]); //  Comparator.comparingInt(x -> x[1])
    int platforms = 1, max = 1, i = 1, j = 0;
    while (i < a.length && j < a.length) {
      if (a[i][0] <= a[j][1]) {
        platforms++;
        i++;
      } else {
        platforms--;
        j++;
      }
      max = max(max, platforms);
    }
    return max;
  }

  public static void main(String[] args) {
    int[] arr = {900, 940, 950, 1100, 1500, 1800};
    int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
    System.out.println(minPlatforms(arr, dep));
    int[][] a = {
        {900, 910},
        {940, 1200},
        {950, 1120},
        {1100, 1130},
        {1500, 1900},
        {1800, 2000},
    };
    System.out.println(minPlatforms(a));
  }
}
