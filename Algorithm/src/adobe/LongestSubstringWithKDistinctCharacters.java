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
        int j = 0, max = 0, maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            map.put(x, map.getOrDefault(x, 0) + 1);
            while (map.size() > k) {
                char y = s.charAt(j);
                map.put(y, map.get(y) - 1);
                if (map.get(y) == 0) {
                    map.remove(y);
                }
                j++;
            }
            if (i - j + 1 > maxLength) {
                maxLength = i - j + 1;
                max = j;
            }
        }
        System.out.println(s.substring(max, max + maxLength) + "\t" + maxLength);
    }

    public static void main(String[] args) {
        longestSubstring("aabacbebebe", 3);
        longestSubstring("aabbcc", 1);
        longestSubstring("aabbcc", 2);
        longestSubstring("aabbcc", 3);
    }
}
