package amazon;

import static util.CommonUtils.printArray;
import static util.CommonUtils.swap;

// Time  Complexity : O(n)
// Space Complexity : O(1)
public class ReArrangeArrayToOddEvenPlace {

  private static void reArrangeArrayToOddEvenPlace(int[] a) {
    int i = 0, j = 1;
    while (i < a.length && j < a.length) {
      if (a[i] % 2 == 1) {
        i += 2;
      } else if (a[j] % 2 == 0) {
        j += 2;
      } else {
        swap(a, i, j);
        j = i + 1;
        i += 2;
      }
    }
    printArray(a);
  }

  public static void main(String[] args) {
    reArrangeArrayToOddEvenPlace(new int[]{4, 5, 1, 2, 3});
    reArrangeArrayToOddEvenPlace(new int[]{2, 1, 5, 6});
  }
}
