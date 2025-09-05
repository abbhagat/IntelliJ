package adobe;

import java.util.*;
import java.util.stream.Collectors;
import static java.lang.Integer.max;

// Time  Complexity : O(n)
// Space Complexity : O(k) k = Size of the character set
public class LongestSubstringWithoutRepeatingCharacters {

    public static void longestSubstring(String s) {
        Set<Character> set = new LinkedHashSet<>();
        int end = 0, max = 0;
        String maxString = "";
        for (int start = 0; start < s.length(); start++) {
            while (set.contains(s.charAt(start))) {
                set.remove(s.charAt(end));
                end++;
            }
            set.add(s.charAt(start));
            String str = set.stream()
                           .map(String::valueOf)
                           .collect(Collectors.joining());
            if (max < start - end + 1) {
                max = start - end + 1;
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
