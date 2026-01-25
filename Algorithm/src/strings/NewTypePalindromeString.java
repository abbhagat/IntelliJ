package strings;

// Time  Complexity : log(n)
// Space Complexity : log(n)
public class NewTypePalindromeString {

  private static boolean isNewTypePalindrome(String s) {
    if (s.isEmpty() || s.length() == 1) {
      return true;
    }
    int mid = (s.length() - 1) / 2;
    int end = s.lastIndexOf(s.charAt(0));
    if (end > mid) {
      String s1 = s.substring(end);
      char lastCharInS1 = s1.charAt(s1.length() - 1);
      int start = s.indexOf(lastCharInS1);
      if (start != -1 && start <= mid) {
        String s2 = s.substring(0, start + 1);
        return s1.equals(s2) && isNewTypePalindrome(s.substring(start + 1, end));
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(isNewTypePalindrome(""));
    System.out.println(isNewTypePalindrome("A"));
    System.out.println(isNewTypePalindrome("ABXAB"));
    System.out.println(isNewTypePalindrome("ABXCDYYDCXBA"));
    System.out.println(isNewTypePalindrome("ABCEDABXYXABCEDAB"));
    System.out.println(isNewTypePalindrome("ABCDXYYXCDAB"));
    System.out.println(isNewTypePalindrome("ABCDXYXDDAB"));
  }
}
