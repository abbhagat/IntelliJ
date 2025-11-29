package adobe;

import static util.CommonUtils.printArray;
import static util.CommonUtils.swap;

// Time  Complexity: O(n)
// Space Complexity: O(1)
public class ArrayRotation {

  private static void rotate(int[] a, int rotationIndex, String rotationType) {
    rotationIndex = rotationIndex % a.length;
    int n = a.length - rotationIndex;
    if (rotationType.equals("left")) {
      rotate(a, 0, n - 1);
      rotate(a, n, a.length - 1);
      rotate(a, 0, a.length - 1);
    } else {
      rotate(a, 0, a.length - 1);
      rotate(a, n, a.length - 1);
      rotate(a, 0, n - 1);
    }
    printArray(a);
  }

  private static void rotate(int[] a, int i, int j) {
    while (i < j) {
      swap(a, i++, j--);
    }
  }

  public static void main(String[] args) {
    rotate(new int[]{1, 2, 3, 4, 5},       2, "left");     // 4 5 1 2 3
    rotate(new int[]{1, 2, 3, 4, 5},       2, "right");   //  3 4 5 1 2
    rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3, "left");   //   5 6 7 1 2 3 4
    rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3, "right"); //    4 5 6 7 1 2 3
  }
}
