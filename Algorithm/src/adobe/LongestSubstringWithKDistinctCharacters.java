package adobe;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

// Time  Complexity : O(n)
// Space Complexity : O(k)
public class LongestSubstringWithKDistinctCharacters {

    public static void longestSubstring(String s, int k) {
        if (s == null || s.isEmpty() || k <= 0) {
            return;
        }
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, maxLength = 0, maxStart = 0;
        for (int end = 0; end < s.length(); end++) {
            char endChar = s.charAt(end);
            map.put(endChar, map.getOrDefault(endChar, 0) + 1);
            while (map.size() > k) {
                char startChar = s.charAt(start);
                map.put(startChar, map.get(startChar) - 1);
                if (map.get(startChar) == 0) {
                    map.remove(startChar);
                }
                start++;
            }
            if (end - start + 1 > maxLength) {
                maxLength = end - start + 1;
                maxStart = start;
            }
        }
        System.out.println(s.substring(maxStart, maxStart + maxLength) + "\t" + maxLength);
    }

    public static void main(String[] args) {
        longestSubstring("aabacbebebe", 3);
        longestSubstring("aabbcc", 1);
        longestSubstring("aabbcc", 2);
        longestSubstring("aabbcc", 3);
    }
}
