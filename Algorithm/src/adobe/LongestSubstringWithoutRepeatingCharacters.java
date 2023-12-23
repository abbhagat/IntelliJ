package adobe;

import static java.lang.Integer.max;

public class LongestSubstringWithoutRepeatingCharacters {

    private static void lengthOfLongestSubstring(char[] c) {
        int j = Integer.MIN_VALUE, max = Integer.MIN_VALUE;
        int[] temp = new int[128];
        for (int i = 0; i < c.length; i++) {
            j = max(j, temp[c[i]]);
            max = max(max, i - j + 1);
            temp[c[i]] = i + 1;
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("abcabcbb".toCharArray());
        lengthOfLongestSubstring("bbbbb".toCharArray());
        lengthOfLongestSubstring("pwwkew".toCharArray());
        lengthOfLongestSubstring("geeksforgeeks".toCharArray());
    }
}
