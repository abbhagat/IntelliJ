package geeks;

import java.util.stream.IntStream;
import static geeks.EquilibriumPointInAnArray.findEquilibriumPoint;

public class DivideArrayInTwoEqualHalf {

  private static void divideArrayInTwoEqualHalf(int[] a) {
    int index = findEquilibriumPoint(a);
    if (index != -1) {
      System.out.print("Equilibrium Point index is " + index + " : ");
      IntStream.range(0, index).forEach(i -> System.out.print(a[i] + " "));
      System.out.print(" and ");
      IntStream.range(index + 1, a.length).forEach(i -> System.out.print(a[i] + " "));
      System.out.println();
    } else {
      System.out.println("Equilibrium Point Does Not Exist");
    }
  }

  public static void main(String[] args) {
    divideArrayInTwoEqualHalf(new int[]{1, 2, 3, 2, 1});
    divideArrayInTwoEqualHalf(new int[]{6, 3, 2, 1});
    divideArrayInTwoEqualHalf(new int[]{1, 3, 3, 2, 1, 1});
  }
}
