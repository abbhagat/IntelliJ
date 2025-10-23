package adobe;

import java.util.Arrays;

public class MinimumDaysToWatchAllMovies {

  public static int findMinimumDays(float[] a) {
    Arrays.sort(a);
    int i = 0, j = a.length - 1, days = 0;
    while (i < j) {
      if (a[i] + a[j] <= 3.0f) {
        i++;
      }
      j--;
      days++;
    }
    if (i == j && a[i] <= 3.0f) {
      days++;
    }
    return days;
  }

  public static void main(String[] args) {
    System.out.println(findMinimumDays(new float[]{1.94f, 2.5f, 1.25f, 1.01f, 1.75f}));
  }
}
