package vmware;

// Given a +ve Integer find min no of perfect square which sum to n
// Time Complexity O(sqrt(n))
// Space Complexity : O(1)

public class PerfectSquares {

  private static boolean isSquare(int n) {
    int sqRoot = (int) Math.sqrt(n);
    return sqRoot * sqRoot == n;
  }

  private static int cntSquares(int n) {
    if (isSquare(n)) {                                 // ans = 1 if the number is a perfect square
      return 1;
    }
    for (int i = 1; i <= (int) Math.sqrt(n); i++) {   // ans = 2: we check for each i if n - (i * i) is a perfect square
      if (isSquare(n - (i * i))) {
        return 2;
      }
    }
    while (n % 4 == 0) {
      n >>= 2;
    }
    return n % 8 == 7 ? 4 : 3;
  }

  public static void main(String[] args) {
    System.out.println(cntSquares(12));
    System.out.println(cntSquares(13));
  }
}
