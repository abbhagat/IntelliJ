package amazon;

/*
  I/P :- int[] a = { 4, 3, 2, 0, 1 };
  O/P :- int[] a = { 0, 1, 2, 3, 4 };
*/

import static util.CommonUtils.printArray;
import static util.CommonUtils.swap;

// Time  Complexity  O(n)
public class SortingInBigO_n {

  private static void sort(int[] a) {
    int i = 0;
    while (i < a.length) {
      if (i != a[i]) {
        swap(a, i, a[i]);
      } else {
        i++;
      }
    }
  }

  public static void main(String[] args) {
    int[] a = {4, 3, 2, 0, 1};
    sort(a);
    printArray(a);
  }
}
