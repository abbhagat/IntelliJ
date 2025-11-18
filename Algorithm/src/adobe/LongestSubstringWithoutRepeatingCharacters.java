package adobe;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

// Time  Complexity : O(n)
// Space Complexity : O(k) k = Size of the character set
public class LongestSubstringWithoutRepeatingCharacters {

  public static void longestSubstring(String s) {
    Set<Character> set = new LinkedHashSet<>();
    int start = 0, max = 0;
    String maxString = "";
    for (int end = 0; end < s.length(); end++) {
      while (set.contains(s.charAt(end))) {
        set.remove(s.charAt(start));
        start++;
      }
      set.add(s.charAt(end));
      String str = set.stream()
          .map(String::valueOf)
          .collect(Collectors.joining());
      if (max < end - start + 1) {
        max = end - start + 1;
        maxString = str;
      }
    }
    System.out.println(maxString + "\t" + max);
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
