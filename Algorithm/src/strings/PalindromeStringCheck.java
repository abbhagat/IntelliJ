package strings;

public class PalindromeStringCheck {

  private static boolean isPalindrome(char[] c) {
    int i = 0, j = c.length - 1;
    while ( i < j) {
      if (c[i] != c[j]) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(isPalindrome("MADAM".toCharArray()));
    System.out.println(isPalindrome("MADDAM".toCharArray()));
    System.out.println(isPalindrome("MADXAM".toCharArray()));
  }
}
