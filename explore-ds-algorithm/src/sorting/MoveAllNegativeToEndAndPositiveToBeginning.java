package sorting;

import java.util.Arrays;

import static util.CommonUtils.swap;

public class MoveAllNegativeToEndAndPositiveToBeginning {

  private static void move(int[] a) {
    int j = 0;
    for (int i = 0; i < a.length; i++) {
      if (a[i] > 0) {
        swap(a, i, j);
        j++;
      }
    }
  }

  public static void main(String[] args) {
    int[] a = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
    move(a);
    System.out.println(Arrays.toString(a));
  }
}
