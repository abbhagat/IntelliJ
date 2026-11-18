package recursion;

public class StringPalindrome {

  private static boolean isPalindrome(String s) {
    if (s.isEmpty() || s.length() == 1) {
      return true;
    }
    return s.charAt(0) == s.charAt(s.length() - 1) && isPalindrome(s.substring(1, s.length() - 1));
  }

  private static boolean isPalindrome(char[] c) {
    for (int i = 0, j = c.length - 1; i < j; i++, j--) {
      if (c[i] != c[j]) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(isPalindrome("MADAM"));
    System.out.println(isPalindrome("MADDM"));
    System.out.println(isPalindrome("MADAM".toCharArray()));
    System.out.println(isPalindrome("MADDM".toCharArray()));
  }
}
