package geeksforgeeks;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class MaxAreaOrContainerWithMaxWater {

  public static int maxArea(int[] a) {
    int low = 0, high = a.length - 1, max = Integer.MIN_VALUE;
    while (low < high) {
      int water = min(a[low], a[high]) * (high - low);
      max = max(max, water);
      int k = a[low] < a[high] ? low++ : high--;
    }
    return max;
  }

  public static int minArea(int[] a) {
    int low = 0, high = a.length - 1, min = Integer.MAX_VALUE;
    while (low < high) {
      int water = min(a[low], a[high]) * (high - low);
      min = min(min, water);
      int k = a[low] < a[high] ? low++ : high--;
    }
    return min;
  }

  public static void main(String[] args) {
    System.out.println(maxArea(new int[]{3, 1, 2, 4}));
    System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    System.out.println(minArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    System.out.println(maxArea(new int[]{1, 2, 3, 4}));
    System.out.println(minArea(new int[]{1, 2, 3, 4}));
    System.out.println(maxArea(new int[]{2, 4}));
    System.out.println(minArea(new int[]{2, 4}));
  }
}
