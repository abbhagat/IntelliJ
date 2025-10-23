package sorting;

import static util.CommonUtils.printArray;
import static util.CommonUtils.swap;

// Time Complexity: O(n)
public class SortArrayHavingZeroOneAndTwo {

  private static void sort(int[] a) {
    int low = 0, mid = 0, high = a.length - 1;
    while (mid <= high) {
      switch (a[mid]) {
        case 0 -> {
          swap(a, low, mid);
          low++;
          mid++;
        }
        case 1 -> mid++;
        case 2 -> {
          swap(a, mid, high);
          high--;
        }
      }
    }
    printArray(a);
  }

  public static void main(String[] args) {
    sort(new int[]{0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1});
  }
}
