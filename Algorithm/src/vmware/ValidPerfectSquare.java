package vmware;

public class ValidPerfectSquare {

  private static boolean isPerfectSquare(int n) {
    int low = 0, high = n;
    while (low <= high) {
      int mid = (low + high) / 2;
      int square = mid * mid;
      if (square == n) {
        return true;
      } else if (n < square) {
        high = mid - 1;
      } else {
        low  = mid + 1;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(isPerfectSquare(16));
    System.out.println(isPerfectSquare(18));
  }
}
