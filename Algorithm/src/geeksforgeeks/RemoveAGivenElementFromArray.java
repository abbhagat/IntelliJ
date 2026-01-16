package geeksforgeeks;

import java.util.Arrays;
import java.util.stream.IntStream;
import static util.CommonUtils.swap;

public class RemoveAGivenElementFromArray {

  private static void removeElementFromArray(int[] a, int n) {
    int j = 0;
    for (int i = 0; i < a.length; i++) {
      if (a[i] != n) {
        swap(a, i, j);
        j++;
      }
    }
    IntStream.range(j, a.length).forEach(i -> a[i] = 0);
    System.out.println(Arrays.toString(a));
  }

  public static void main(String[] args) {
    removeElementFromArray(new int[]{0, 1, 2, 2, 3, 2, 4, 2}, 2);
    removeElementFromArray(new int[]{0, 1, 2, 2, 3, 2, 3, 2}, 3);
    removeElementFromArray(new int[]{3, 2, 2, 3}, 3);
  }
}
