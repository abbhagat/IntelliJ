package adobe;

import java.util.HashMap;
import java.util.Map;

// Time  Complexity : O(n log n)
// Space Complexity : O(log n)
public class LongestSubstringWithAtLeastKRepeatingChars {

  private record Index(int start, int end, int length) {}

  private static Index longestSubString(String s, int start, int end, int k) {
    Map<Character, Integer> map = new HashMap<>();
    s.chars().forEach(c -> map.put((char) c, map.getOrDefault((char) c, 0) + 1));
    for (int i = start; i < end; i++) {
      char c = s.charAt(i);
      if (map.get(c) < k) {
        Index left  = longestSubString(s, start, i, k);
        Index right = longestSubString(s, i + 1, end, k);
        return (left.length >= right.length) ? left : right;
      }
    }
    return new Index(start, end, end - start);
  }

  public static void main(String[] args) {
    Index index = longestSubString("ababbc", 0, "ababbc".length(), 2);
    System.out.println("ababbc".substring(index.start, index.end) + "\t" + index.length);

    index = longestSubString("aaabb", 0, "aaabb".length(), 3);
    System.out.println("aaabb".substring(index.start, index.end) + "\t" + index.length);

    index = longestSubString("aaabbb", 0, "aaabbb".length(), 3);
    System.out.println("aaabbb".substring(index.start, index.end) + "\t" + index.length);
  }
}
