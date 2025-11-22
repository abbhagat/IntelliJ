package adobe;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

// Time  Complexity : O(n log n)
// Space Complexity : O(log n) The recursion stack depth is proportional to the number of divisions,
// which is at most log n in the worst case
public class LongestSubstringWithAtLeastKRepeatingCharacters {

  private static int longestSubString(String s, int start, int end, int k) {
    Map<Character, Integer> map = new HashMap<>();
    s.chars().forEach(c -> map.put((char) c, map.getOrDefault((char) c, 0) + 1));
    for (int i = start; i < end; i++) {
      if (map.get(s.charAt(i)) < k) {
        return max(longestSubString(s, start, i, k), longestSubString(s, i + 1, end, k));
      }
    }
    return end - start;
  }

  private static int smallestSubString(String s, int start, int end, int k) {
    Map<Character, Integer> map = new HashMap<>();
    s.chars().forEach(c -> map.put((char) c, map.getOrDefault((char) c, 0) + 1));
    for (int i = start; i < end; i++) {
      if (map.get(s.charAt(i)) < k) {
        return min(smallestSubString(s, start, i, k), smallestSubString(s, i + 1, end, k));
      }
    }
    return end - start;
  }

  public static void main(String[] args) {
    System.out.println(longestSubString("ababbc", 0, "ababbc".length(), 2));
    System.out.println(longestSubString("aaabb",  0, "aaabb".length(),  2));
    System.out.println(longestSubString("aaabbb", 0, "aaabbb".length(), 2));
    System.out.println(longestSubString("ababbc", 0, "ababbc".length(), 3));
    System.out.println(longestSubString("aaabb",  0, "aaabb".length(),  3));
    System.out.println(longestSubString("aaabbb", 0, "aaabbb".length(), 3));
    System.out.println();
    System.out.println(smallestSubString("ababbc", 0, "ababbc".length(), 2));
    System.out.println(smallestSubString("aaabb",  0, "aaabb".length(),  2));
    System.out.println(smallestSubString("aaabbb", 0, "aaabbb".length(), 2));
    System.out.println(smallestSubString("ababbc", 0, "ababbc".length(), 3));
    System.out.println(smallestSubString("aaabb",  0, "aaabb".length(),  3));
    System.out.println(smallestSubString("aaabbb", 0, "aaabbb".length(), 3));
  }
}
