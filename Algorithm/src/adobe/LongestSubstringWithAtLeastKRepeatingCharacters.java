package adobe;

import static java.lang.Integer.max;

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public static int longestSubstring(String s, int k) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int[] temp = new int[128];
        for (char c : s.toCharArray()) {
            temp[c]++;
        }
        boolean flag = true;
        for (int x : temp) {
            if (x > 0 && x < k) {
                flag = false;
                break;
            }
        }
        if (flag) {
            return s.length();
        }
        int max = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (temp[s.charAt(i)] < k) {
                max   = max(max, longestSubstring(s.substring(start, i), k));
                start = i + 1;
            }
        }
        return max(max, longestSubstring(s.substring(start), k));
    }

    public static void main(String[] args) {
        System.out.println(longestSubstring("aaabb", 3));
        System.out.println(longestSubstring("aaabbb", 3));
        System.out.println(longestSubstring("ababbc",2));
    }
}
