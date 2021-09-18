package leetcode;

import static java.lang.Integer.max;

public class LongestSubstring {

    private static int lengthOfLongestSubstring(char[] c) {
        int result = 0;
        int[] temp = new int[128];
        for (int i = 0, j = 0; j < c.length; j++) {
            i = max(i, temp[c[j]]);
            result = max(result, j - i + 1);
            temp[c[j]] = j + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("abcabcbb" + " " + lengthOfLongestSubstring("abcabcbb".toCharArray()));
        System.out.println("bbbbb"    + " " + lengthOfLongestSubstring("bbbbb".toCharArray()));
        System.out.println("pwwkew"   + " " + lengthOfLongestSubstring("pwwkew".toCharArray()));
    }
}
