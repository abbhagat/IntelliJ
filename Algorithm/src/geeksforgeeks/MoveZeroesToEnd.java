package geeksforgeeks;

import java.util.stream.IntStream;
import static util.CommonUtils.printArray;
import static util.CommonUtils.swap;

/**
 * Given an int[] a move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Input: a = [0,1,0,3,12] Output: [1,3,12,0,0]
 * Input: a = [0] Output: [0]
 */

public class MoveZeroesToEnd {

  private static void moveZeroesToStart(int[] a) {
    int j = a.length - 1;
    for (int i = a.length - 1; i >= 0; i--) {
      if (a[i] != 0) {
        swap(a, i, j);
        j--;
      }
    }
    IntStream.range(0, j + 1).forEach(i -> a[i] = 0);
    printArray(a);
  }

  private static void moveZeroesToEnd(int[] a) {
    int j = 0;
    for (int i = 0; i < a.length; i++) {
      if (a[i] != 0) {
        swap(a, i, j);
        j++;
      }
    }
    printArray(a);
  }

  public static void main(String[] args) {
    moveZeroesToEnd(new int[]{0});
    moveZeroesToEnd(new int[]{0, 1, 0, 3, 12});
    moveZeroesToEnd(new int[]{0, 1, 0, 0, 3, 4, 12, 0, 0, 0});
    moveZeroesToStart(new int[]{0});
    moveZeroesToStart(new int[]{0, 1, 0, 3, 12});
    moveZeroesToStart(new int[]{0, 1, 0, 0, 3, 4, 12, 0, 0, 0});
  }
}
