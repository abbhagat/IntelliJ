package geeks;

import java.util.Arrays;
import java.util.stream.IntStream;

public class DivideArrayInTwoEqualHalf {

  private static void divideArrayInTwoEqualHalf(int[] a) {
    int index = findEquilibriumPoint(a);
    if (index != -1) {
      System.out.println("Equilibrium Point Index is " + index);
      IntStream.range(0, index).forEach(i -> System.out.print(a[i] + " "));
      System.out.print(" and ");
      IntStream.range(index + 1, a.length).forEach(i -> System.out.print(a[i] + " "));
      System.out.println();
    } else {
      System.out.println("Equilibrium Point Does Not Exist");
    }
  }

  private static int findEquilibriumPoint(int[] a) {
    int sum1 = Arrays.stream(a).sum();
    int sum2 = 0;
    for (int i = 0; i < a.length; i++) {
      sum2 += a[i];
      if (sum1 == sum2) {
        return i;
      }
      sum1 -= a[i];
    }
    return -1;
  }

  public static void main(String[] args) {
    divideArrayInTwoEqualHalf(new int[]{1, 2, 3, 2, 1});
    divideArrayInTwoEqualHalf(new int[]{6, 3, 2, 1});
    divideArrayInTwoEqualHalf(new int[]{1, 3, 3, 2, 1, 1});
  }
}
