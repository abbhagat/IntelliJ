package leetcode;

import static java.lang.Integer.min;

// Time Complexity O(n log n)

public class LongestCommonPrefix {

    private static String longestCommonPrefix(String[] str, int low, int high) {
        if (low == high) {
            return str[low];
        }
        int mid = (low + high) / 2;
        String left = longestCommonPrefix(str, low, mid);
        String right = longestCommonPrefix(str, mid + 1, high);
        return commonPrefix(left, right);
    }

    private static String commonPrefix(String left, String right) {
        int min = min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }
        return left.substring(0, min);
    }

    public static void main(String[] args) {
        String[][] str = {
                           {"flower", "flow", "flight"},
                           {"flower", "flow"},
                           {"flower"}
                         };
        for (String[] s : str) {
            System.out.println(longestCommonPrefix(s, 0, s.length - 1));
        }
    }
}
