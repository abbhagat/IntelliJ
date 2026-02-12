package adobe;

import java.util.Set;
import java.util.HashSet;

// Time  Complexity : O(n)
// Space Complexity : O(k) k = Size of the character set
public class LongestSubstringWithoutRepeatingCharacters {

  public static void longestSubstring(String s) {
    Set<Character> set = new HashSet<>();
    int start = 0, maxLen = 0, startIndex = 0;
    for (int end = 0; end < s.length(); end++) {
      while (set.contains(s.charAt(end))) {
        set.remove(s.charAt(start));
        start++;
      }
      set.add(s.charAt(end));
      if (maxLen < end - start + 1) {
        maxLen = end - start + 1;
        startIndex  = start;
      }
    }
    System.out.println(s.substring(startIndex, startIndex + maxLen) + "\t" + maxLen);
  }

  public static void main(String[] args) {
    longestSubstring("abcabcbb");
    longestSubstring("aabacbebebe");
    longestSubstring("bbbbb");
    longestSubstring("pwwkew");
    longestSubstring("geeksforgeeks");
    longestSubstring("kyckyckk");
  }
}
