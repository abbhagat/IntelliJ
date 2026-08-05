package geeks;

import java.util.stream.IntStream;
import static geeks.EquilibriumPointInAnArray.findEquilibriumPoint;

public class DivideArrayInTwoEqualHalf {

  private static void divideArrayInTwoEqualHalf(int[] a) {
    int equilibriumPoint = findEquilibriumPoint(a);
    if (equilibriumPoint != -1) {
      System.out.print("Equilibrium Point index is " + equilibriumPoint + " : ");
      IntStream.range(0, equilibriumPoint).forEach(i -> System.out.print(a[i] + " "));
      System.out.print(" and ");
      IntStream.range(equilibriumPoint + 1, a.length).forEach(i -> System.out.print(a[i] + " "));
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
