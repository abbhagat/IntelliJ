package adobe;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

// Time  Complexity : O(n)
// Space Complexity : O(k) k = Size of the character set
public class LongestSubstringWithoutRepeatingCharacters {

  public static void longestSubstring(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int start = 0, maxLen = 0, startIndex = 0;
    for (int end = 0; end < s.length(); end++) {
      char c = s.charAt(end);
      while (map.containsKey(c)) {
        map.remove(s.charAt(start));
        start++;
      }
      map.put(c, map.getOrDefault(c, 0) + 1);
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
