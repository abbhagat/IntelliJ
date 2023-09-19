package leetcode;

import static java.lang.Integer.max;

public class LongestSubstringWithoutRepeatingCharacters {

    private static int lengthOfLongestSubstring(char[] c) {
        int result = 0, max = Integer.MIN_VALUE;
        int[] temp = new int[128];
        for (int i = 0; i < c.length; i++) {
            max = max(max, temp[c[i]]);
            result = max(result, i - max + 1);
            temp[c[i]] = i + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("abcabcbb"        + " " + lengthOfLongestSubstring("abcabcbb".toCharArray()));
        System.out.println("bbbbb"           + " " + lengthOfLongestSubstring("bbbbb".toCharArray()));
        System.out.println("pwwkew"          + " " + lengthOfLongestSubstring("pwwkew".toCharArray()));
        System.out.println("geeksforgeeks"   + " " + lengthOfLongestSubstring("pwwkew".toCharArray()));
    }
}
