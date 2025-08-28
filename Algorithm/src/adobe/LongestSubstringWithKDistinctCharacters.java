package adobe;

import java.util.HashMap;
import java.util.Map;

// Time  Complexity : O(n)
// Space Complexity : O(k)
public class LongestSubstringWithKDistinctCharacters {

    public static void longestSubstring(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, startIndex = 0, max = 0;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.size() > k) {
                char y = s.charAt(start);
                map.put(y, map.get(y) - 1);
                if (map.get(y) == 0) {
                    map.remove(y);
                }
                start++;
            }
            if (end - start + 1 > max) {
                max   = end - start + 1;
                startIndex = start;
            }
        }
        System.out.println(s.substring(startIndex, startIndex + max) + "\t" + max);
    }

    public static void main(String[] args) {
        longestSubstring("aabacbebebe", 3);
        longestSubstring("aabbcc", 1);
        longestSubstring("aabbcc", 2);
        longestSubstring("aabbcc", 3);
    }
}
