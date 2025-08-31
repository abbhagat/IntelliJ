package adobe;

import java.util.HashMap;
import java.util.Map;

// Time  Complexity : O(n)
// Space Complexity : O(k)
public class LongestSubstringWithKDistinctCharacters {

    public static void longestSubstring(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int j = 0, startIndex = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
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
            if (i - j + 1 > max) {
                max   = i - j + 1;
                startIndex = j;
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
