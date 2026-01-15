package geeksforgeeks;

/*
    strStr("hello", "ll") → 2
    strStr("aaaaa", "bba") → -1
    strStr("abc", "") → 0      // empty string always matches at index 0
 */

public class Implement_strStr {

  private static int strStr(String s1, String s2) {
    if (s2.isEmpty() || s2.equals(s1)) {
      return 0;
    }
    if (s2.length() > s1.length()) {
      return -1;
    }
    for (int i = 0; i <= s1.length() - s2.length(); i++) {
      int j = 0;
      while (j < s2.length() && s1.charAt(i + j) == s2.charAt(j)) {
        j++;
      }
      if (j == s2.length()) {
        return i;
      }
    }
    return -1;
  }

  private static int str_str(String s1, String s2) {
    if (s2.isEmpty() || s2.equals(s1)) {
      return 0;
    }
    return s1.indexOf(s2);
  }

  public static void main(String[] args) {
    System.out.println("mississippi".indexOf(""));
    System.out.println(strStr("mississippi", "issipi") + "\t" + str_str("mississippi", "issipi"));
    System.out.println(strStr("mississippi", "issip")  + "\t" + str_str("mississippi", "issip"));
    System.out.println(strStr("abc", "c")              + "\t" + str_str("abc", "c"));
    System.out.println(strStr("ABEFGCDEFG", "EFG")     + "\t" + str_str("ABEFGCDEFG", "EFG"));
    System.out.println(strStr("ABEFGCDEFG", "EFHG")    + "\t" + str_str("ABEFGCDEFG", "EFHG"));
  }
}
