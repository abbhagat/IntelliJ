package adobe;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

// Time  Complexity : O(n)
// Space Complexity : O(k) k = Size of the character set
public class LongestSubstringWithoutRepeatingCharacters {

  public static void longestSubstring(String s) {
    Set<Character> set = new LinkedHashSet<>();
    int j = 0, max = 0;
    String maxString = "";
    for (int i = 0; i < s.length(); i++) {
      if (set.contains(s.charAt(i))) {
        set.remove(s.charAt(j));
        j++;
      }
      set.add(s.charAt(i));
      String str = set.stream().map(String::valueOf).collect(Collectors.joining());
      if (max < i - j + 1) {
        max = i - j + 1;
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
