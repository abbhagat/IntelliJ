package adobe;

import java.util.HashMap;
import java.util.Map;
import static java.lang.Integer.max;

// Time  Complexity : O(n)
// Space Complexity : O(k) k = Size of the character set
public class LongestSubstringWithoutRepeatingCharacters {

  public static void longestSubstring(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int start = 0, maxLen = 0, index = 0;
    for (int end = 0; end < s.length(); end++) {
      char c = s.charAt(end);
      if (map.containsKey(c)) {
        start = max(start, map.get(c) + 1);
      }
      map.put(c, end);
      if (end - start + 1 > maxLen) {
        maxLen = end - start + 1;
        index = start;
      }
    }
    String maxString = s.substring(index, index + maxLen);
    System.out.println(maxString + "\t" + maxLen);
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
