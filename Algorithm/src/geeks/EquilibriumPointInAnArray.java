package geeks;

import java.util.Arrays;

public class EquilibriumPointInAnArray {

  public static int findEquilibriumPoint(int[] a) {
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
    int[] a = new int[]{1, 2, 3, 2, 1};
    int i =  findEquilibriumPoint(a);
    System.out.println(i == -1 ? -1 : a[i]);

    int[] b = new int[]{1, 3, 4, 2, 15, 6, 3, 1};
    i =  findEquilibriumPoint(b);
    System.out.println(i == -1 ? -1 : b[i]);

    int[] c = new int[]{6, 3, 2, 1};
    i =  findEquilibriumPoint(c);
    System.out.println(i == -1 ? -1 : c[i]);
  }
}
