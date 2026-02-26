package jpmorgan;

// Time Complexity  : O(n^2)
// Space Complexity : O(1)
public class PrintTriangleInPattern {

  private static void printPattern(int n) {
    int mid = n / 2;
    for (int i = 1; i <= mid; i++) {    // Upper half
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
    // Lower half
    for (int i = mid; i >= 1; i--) {  // Lower half
      for (int j = 1; j <= i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    printPattern(5);
    System.out.println();
    printPattern(7);
  }
}
