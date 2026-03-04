package adobe;

import java.util.HashMap;
import java.util.Map;

// Time  Complexity : O(n)
// Space Complexity : O(k)
public class LongestSubstringWithKDistinctCharacters {

  public static void longestSubstring(String s, int k) {
    Map<Character, Integer> map = new HashMap<>();
    int j = 0, i;
    for (i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      map.put(c, map.getOrDefault(c, 0) + 1);
      while (map.size() > k) {
        char y = s.charAt(j);
        map.put(y, map.get(y) - 1);
        if (map.get(y) == 0) {
          map.remove(y);
        }
        j++;
      }
    }
    String str = s.substring(j, i);
    System.out.println(str + "\t" + str.length());
  }

  public static void main(String[] args) {
    longestSubstring("aabacbebebe", 3);
    longestSubstring("aabbcc", 1);
    longestSubstring("aabbcc", 2);
    longestSubstring("aabbcc", 3);
    longestSubstring("abcabc", 3);
  }
}
