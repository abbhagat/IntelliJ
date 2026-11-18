package sorting;

import static util.CommonUtils.printArray;
import static util.CommonUtils.swap;

public class SortArrayWithZeroAndOneWithoutCalculatingArrayLength {

  private static void sort(int[] a) {
    int j = 0;
    for (int i = 0; true; i++) {
      try {
        if (a[i] == 0) {
          swap(a, i, j);
          j++;
        }
      } catch (ArrayIndexOutOfBoundsException e) {
        break;
      }
    }
    printArray(a);
  }

  public static void main(String[] args) {
    sort(new int[]{0, 0, 1, 0, 1, 0, 0, 0, 1, 1});
  }
}
