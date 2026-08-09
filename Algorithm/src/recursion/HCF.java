package recursion;

import static java.lang.Integer.max;

public class HCF {

  // Time Complexity : O log(min(x,y))
  // Space Complexity: O log(min(x,y))
  private static int findHCF(int x, int y) {
    return y == 0 ? x : findHCF(y, x % y);
  }

  // Time  Complexity: O(min(x,y))
  // Space Complexity: O(1)
  private static int findGCD(int x, int y) {
    while(y != 0) {
      int t = x % y;
      x = y;
      y = t;
    }
    return x;
  }

  public static void main(String[] args) {
    int[] a = {10, 150, 30, 50, 40, 60};
    int hcf = a[0];
    for (int i = 1; i < a.length; i++) {
      hcf = findHCF(hcf, a[i]);
    }
    System.out.println("HCF := " + hcf);
    System.out.println(findHCF(0, 5)   + "\t" + findGCD(0, 5));
    System.out.println(findHCF(0, 5)   + "\t" + findGCD(0, 5));
    System.out.println(findHCF(5, 10)  + "\t" + findGCD(5, 10));
    System.out.println(findHCF(10, 5)  + "\t" + findGCD(10, 5));
    System.out.println(findHCF(0, 0)   + "\t" + findGCD(0, 0));
    System.out.println(findHCF(5, 15)  + "\t" + findGCD(5, 15));
  }
}
