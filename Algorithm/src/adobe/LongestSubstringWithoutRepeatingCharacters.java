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
    int j = 0, max = 0, startIndex = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      while (map.containsKey(c)) {  // check for repeating char
        char y = s.charAt(j);
        map.remove(y);
        j++;
      }
      map.put(c, map.getOrDefault(c, 0) + 1);
      if (max < i - j + 1) {
          max = i - j + 1;
          startIndex = j;
      }
    }
    System.out.println(s.substring(startIndex, startIndex + max) + "\t" + max);
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
