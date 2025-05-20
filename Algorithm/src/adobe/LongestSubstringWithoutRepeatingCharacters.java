package adobe;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Integer.max;

// Time  Complexity : O(n)
// Space Complexity : O(1)
public class LongestSubstringWithoutRepeatingCharacters {

    public static void lengthOfLongestSubstring(String s) {
        Set<Character> set = new LinkedHashSet<>();
        int max = 0, j = 0;
        String maxString = "";
        for (int i = 0; i < s.length(); i++) {
            while (set.contains(s.charAt(i))) {
                set.remove(s.charAt(j));
                j++;
            }
            set.add(s.charAt(i));
            String str = set.stream().map(String::valueOf).collect(Collectors.joining());
            max = max(max, i - j + 1);
            maxString = maxString.length() < str.length() ? str : maxString;
        }
        System.out.println(maxString + "\t" + max);
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("abcabcbb");
        lengthOfLongestSubstring("aabacbebebe");
        lengthOfLongestSubstring("bbbbb");
        lengthOfLongestSubstring("pwwkew");
        lengthOfLongestSubstring("geeksforgeeks");
        lengthOfLongestSubstring("kyckyckk");
    }
}
