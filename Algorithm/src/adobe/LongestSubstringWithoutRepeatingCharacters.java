package adobe;

import java.util.HashMap;
import java.util.Map;

// Time  Complexity : O(n)
// Space Complexity : O(k) k = Size of the character set
public class LongestSubstringWithoutRepeatingCharacters {

  public static void longestSubstring(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int j = 0, max = 0;
    String maxStr = "";
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      while (map.containsKey(c)) {  // check for repeating char
        char y = s.charAt(j);
        map.put(y, map.get(y) - 1);
        if (map.get(y) == 0) {
          map.remove(y);
        }
        j++;
      }
      map.put(c, map.getOrDefault(c, 0) + 1);
      if (max < i - j + 1) {
          max = i - j + 1;
          maxStr = s.substring(j, i + 1);
      }
    }
    System.out.println(maxStr + "\t" + maxStr.length());
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
