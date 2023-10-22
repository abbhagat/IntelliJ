package leetcode;

import static java.lang.Integer.max;

public class LongestSubstringWithoutRepeatingCharacters {

    private static int lengthOfLongestSubstring(char[] c) {
        int max = 0, j = Integer.MIN_VALUE;
        int[] temp = new int[128];
        for (int i = 0; i < c.length; i++) {
            j = max(j, temp[c[i]]);
            max = max(max, i - j + 1);
            temp[c[i]] = i + 1;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("abcabcbb" + " " + lengthOfLongestSubstring("abcabcbb".toCharArray()));
        System.out.println("bbbbb" + " " + lengthOfLongestSubstring("bbbbb".toCharArray()));
        System.out.println("pwwkew" + " " + lengthOfLongestSubstring("pwwkew".toCharArray()));
        System.out.println("geeksforgeeks" + " " + lengthOfLongestSubstring("geeksforgeeks".toCharArray()));
    }
}
