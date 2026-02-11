package geeksforgeeks;

/*
    strStr("hello", "ll") → 2
    strStr("aaaaa", "bba") → -1
    strStr("abc", "") → 0      // empty needle always matches at index 0
 */

public class Implement_strStr {

  public static int strStr(String s1, String s2) {
    if (s2.isEmpty() || s2.equals(s1)) {
      return 0;
    }
    if (s2.length() > s1.length()) {
      return -1;
    }
    String s = "";
    int index = -1, j = 0;
    for (int i = 0; i < s1.length() && j < s2.length(); i++) {
      if (s1.charAt(i) == s2.charAt(j)) {
        index = index == -1 ? i : index;
        s += s1.charAt(i);
        j++;
        if (s.equals(s2)) {
          return index;
        }
      } else {
        i = index != -1 ? index : i;
        s = "";
        index = -1;
        j = 0;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println("mississippi".indexOf(""));
    System.out.println(strStr("mississippi", "issipi"));
    System.out.println(strStr("mississippi", "issip"));
    System.out.println(strStr("abc", "c"));
    System.out.println(strStr("ABEFGCDEFG", "EFG"));
    System.out.println(strStr("ABEFGCDEFG", "EFHG"));
  }
}
