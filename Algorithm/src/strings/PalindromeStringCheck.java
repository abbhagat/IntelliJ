package strings;

public class PalindromeStringCheck {

  private static boolean isPalindrome(char[] c) {
    for (int i = 0, j = c.length - 1; i < j; i++, j--) {
      if (c[i] != c[j]) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(isPalindrome("MADAM".toCharArray()));
    System.out.println(isPalindrome("MADDAM".toCharArray()));
    System.out.println(isPalindrome("MADXAM".toCharArray()));
  }
}
