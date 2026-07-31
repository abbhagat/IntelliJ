package adobe;

import static java.lang.Integer.max;

public class LongestSubsequenceSubstring {

  public static int longestSubsequenceSubstring(String s1, String s2) {
    int max = 0;
    for (int i = 0; i < s2.length(); i++) {
      StringBuilder sb = new StringBuilder();
      for (int j = i; j < s2.length(); j++) {
        sb.append(s2.charAt(j));
        if (isSubsequence(s1, sb)) {
          max = max(max, sb.length());
        }
      }
    }
    return max;
  }

  private static boolean isSubsequence(String s, CharSequence c) {
    int i = 0, j = 0;
    while (i < s.length() && j < c.length()) {
      if (s.charAt(i) == c.charAt(j)) {
        j++;
      }
      i++;
    }
    return j == c.length();
  }

  public static void main(String[] args) {
    System.out.println(longestSubsequenceSubstring("abcd", "abdc"));      //3
    System.out.println(longestSubsequenceSubstring("abcde", "ace"));       //2 ("ce")
    System.out.println(longestSubsequenceSubstring("abcdef", "zabxy"));    //2 ("ab")
    System.out.println(longestSubsequenceSubstring("abc", "xyz"));         //0
    System.out.println(longestSubsequenceSubstring("banana", "ananas"));   //5 ("anana")
  }
}
