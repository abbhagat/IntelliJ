package sorting;

import static util.CommonUtils.printArray;
import static util.CommonUtils.swap;

// Time Complexity O(n^2)
public class InsertionSort {

  private static void insertionSort(int[] a) {
    for (int i = 1; i < a.length; i++) {
      int j = i - 1;
      while (j >= 0 && a[j] > a[j + 1]) {
        swap(a, j, j + 1);
        j--;
      }
    }
    printArray(a);
  }

  public static void main(String[] args) {
    insertionSort(new int[]{4, 5, 3, 2, 1});
    insertionSort(new int[]{20, 3, 15, 6, 9, 8, 2, 1, 6, 8, 7, 15});
  }
}
