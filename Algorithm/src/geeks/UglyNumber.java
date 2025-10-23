package geeks;

public class UglyNumber {

  private static boolean isUgly(int n) {
    if (n == 0) return false;
    if (n == 1) return true;
    if (n % 2 == 0) return isUgly(n / 2);
    if (n % 3 == 0) return isUgly(n / 3);
    if (n % 5 == 0) return isUgly(n / 5);
    return false;
  }

  public static void main(String[] args) {
    System.out.println(isUgly(6));
    System.out.println(isUgly(8));
    System.out.println(isUgly(14));
  }
}
