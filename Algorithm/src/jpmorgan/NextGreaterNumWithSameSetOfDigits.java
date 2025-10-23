package jpmorgan;

import static util.CommonUtils.printArray;
import static util.CommonUtils.swap;

// Time  Complexity : O(n)
// Space Complexity : O(n)
public class NextGreaterNumWithSameSetOfDigits {

  private static int[] nextPermutation(int[] a) {
    if (a.length == 1) {
      return a;
    }
    int i;
    for (i = a.length - 1; i > 0; i--) {
      if (a[i] > a[i - 1])
        break;
    }
    if (i != 0) {
      for (int j = a.length - 1; j >= i; j--) {
        if (a[j] > a[i - 1]) {
          swap(a, j, i - 1);
          break;
        }
      }
    }
    int k = a.length - 1;
    int[] b = new int[a.length];
    System.arraycopy(a, 0, b, 0, i);
    for (int j = i; j < b.length; j++) {
      b[j] = a[k];
      k--;
    }
    return b;
  }

  public static void main(String[] args) {
    printArray(nextPermutation(new int[]{3, 1, 2}));
  }
}
