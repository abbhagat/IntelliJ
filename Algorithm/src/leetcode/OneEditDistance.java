package leetcode;

import static java.lang.Math.abs;

// Time Complexity: O(n) n = length of the shorter string between s1 and s2.
public class OneEditDistance {

    private static boolean isOneEditDistance(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (abs(n - m) > 1) {
            return false;
        }
        for (int i = 0; i < m; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (m == n) {
                    return s1.substring(i + 1).equals(s2.substring(i + 1));
                }
                if (m < n) {
                    return s1.substring(i).equals(s2.substring(i + 1));
                }
            }
        }
        return m != n;
    }

    public static void main(String[] args) {
        System.out.println(isOneEditDistance("ab", "acb"));
        System.out.println(isOneEditDistance("ad", "cab"));
        System.out.println(isOneEditDistance("1203", "1213"));
    }
}
