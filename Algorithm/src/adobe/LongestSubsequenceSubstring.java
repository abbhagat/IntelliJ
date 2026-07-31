package adobe;

import static java.lang.Integer.max;

public class LongestSubsequenceSubstring {

  public static int longestSubsequenceSubstring(String s1, String s2) {
    int max = 0;
    for (int i = 0; i < s2.length(); i++) {
      String s = "";
      for (int j = i; j < s2.length(); j++) {
        s += s2.charAt(j);
        if (isSubsequence(s1, s)) {
          max = max(max, s.length());
        }
      }
    }
    return max;
  }

  private static boolean isSubsequence(String s1, String s2) {
    int j = 0;
    for (int i = 0; i < s1.length() && j < s2.length(); i++) {
      if (s1.charAt(i) == s2.charAt(j)) {
        j++;
      }
    }
    return j == s2.length();
  }

  public static void main(String[] args) {
    System.out.println(longestSubsequenceSubstring("abcd", "abdc"));       //3
    System.out.println(longestSubsequenceSubstring("abcde", "ace"));       //3 ("ace")
    System.out.println(longestSubsequenceSubstring("abcdef", "zabxy"));    //2 ("ab")
    System.out.println(longestSubsequenceSubstring("abc", "xyz"));         //0
    System.out.println(longestSubsequenceSubstring("banana", "ananas"));   //5 ("anana")
  }
}
