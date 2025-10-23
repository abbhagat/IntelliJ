package geeks;

public class SpecialPalindrome {

  private static boolean palindrome(int n) {
    return n == reverse(n);
  }

  private static int reverse(int n) {
    int rev = 0;
    while (n != 0) {
      int k = n % 10;
      rev = (rev * 10) + k;
      n /= 10;
    }
    return rev;
  }

  public static void main(String[] args) {
    int n = 195;
    while (true) {
      if (palindrome(n)) {
        System.out.println(n);
        break;
      }
      n = n + reverse(n);
    }
  }
}
