package cisco;

import static java.lang.Integer.max;

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public static int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] temp = new int[128];
        for (char c : s.toCharArray()) {
            temp[c]++;
        }
        boolean flag = true;
        for (int j : temp) {
            if (j > 0 && j < k) {
                flag = false;
                break;
            }
        }
        if (flag) {
            return s.length();
        }
        int result = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (temp[s.charAt(i)] < k) {
                result = Math.max(result, longestSubstring(s.substring(start, i), k));
                start = i + 1;
            }
        }
        return max(result, longestSubstring(s.substring(start), k));
    }

    public static void main(String[] args) {
        System.out.println(longestSubstring("aaabb", 3));
        System.out.println(longestSubstring("ababbc", 2));
    }
}
