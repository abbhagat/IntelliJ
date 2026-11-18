package sorting;

import static util.CommonUtils.printArray;
import static util.CommonUtils.swap;

public class MoveAllPositiveToEndAndNegativeToBeginning {

  private static void move(int[] a) {
    int j = 0;
    for (int i = 0; i < a.length; i++) {
      if (a[i] < 0) {
        swap(a, i, j);
        j++;
      }
    }
  }

  public static void main(String[] args) {
    int[] a = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
    move(a);
    printArray(a);
  }
}
