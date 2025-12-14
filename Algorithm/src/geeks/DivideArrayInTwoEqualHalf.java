package geeks;

import java.util.Arrays;
import java.util.stream.IntStream;

public class DivideArrayInTwoEqualHalf {

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
    int[] a = {1, 2, 3, 2, 1};
    int index = findEquilibriumPoint(a);
    System.out.println("Equilibrium Point " + a[index]);
    if (index != -1) {
      IntStream.range(0, index).forEach(i -> System.out.print(a[i] + " "));
      IntStream.range(index + 1, a.length).forEach(i -> System.out.print(a[i] + " "));
    } else {
      System.out.println("Equilibrium Point Does Not Exist");
    }
  }
}
