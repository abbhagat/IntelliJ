package adobe;

import static java.lang.Integer.max;

public class LongestCommonSubsequence {

    public static int lcs(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return 1 + lcs(s1, s2, m - 1, n - 1);
        }
        return max(lcs(s1, s2, m - 1, n), lcs(s2, s2, m, n - 1));
    }

    private static int lcsDP(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = s1.charAt(i - 1) == s2.charAt(j - 1) ? 1 + dp[i - 1][j - 1] : max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(lcsDP("cat", "cut"));
        System.out.println(lcsDP("geek", "gesek"));
        System.out.println(lcsDP("sunday", "saturday"));
        System.out.println(lcsDP("ros", "horse"));
        System.out.println(lcsDP("sea", "eat"));
        System.out.println(lcsDP("AGGTAB", "GXTXAYB"));
        System.out.println(lcsDP("abcde", "ace"));
        System.out.println(lcsDP("abcde", "ace"));
    }
}
