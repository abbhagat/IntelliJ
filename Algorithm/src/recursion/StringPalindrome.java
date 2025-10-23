package recursion;

public class StringPalindrome {

  private static boolean isPalindrome(String s) {
    if (s.isEmpty() || s.length() == 1) {
      return true;
    }
    return s.charAt(0) == s.charAt(s.length() - 1) && isPalindrome(s.substring(1, s.length() - 1));
  }

  public static void main(String[] args) {
    System.out.println(isPalindrome("MADAM") ? "Palindrome" : "Not Palindrome");
    System.out.println(isPalindrome("MADDM") ? "Palindrome" : "Not Palindrome");
  }
}
