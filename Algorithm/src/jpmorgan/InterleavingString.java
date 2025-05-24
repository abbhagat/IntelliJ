package jpmorgan;

public class InterleavingString {

    // Time Complexity: O(2^n), where n is the length of the given string.
    // Space Complexity: O(1).
    public static boolean isInterleaved(String s1, String s2, String s3) {
        if (s1.isEmpty() && s2.isEmpty() && s3.isEmpty()) {
            return true;
        }
        if (s3.isEmpty()) {
            return false;
        }
        if (!s1.isEmpty()) {
            return s1.charAt(0) == s3.charAt(0) && isInterleaved(s1.substring(1), s2, s3.substring(1));
        }
        if (!s2.isEmpty()) {
            return s2.charAt(0) == s3.charAt(0) && isInterleaved(s1, s2.substring(1), s3.substring(1));
        }
        return true;
    }

    // Time  Complexity: O(m*n)
    // Space Complexity: O(m*n)
    public static boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)
                        || dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(isInterleaved("XXY", "XXZ", "XXZXXXY"));
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(isInterleaved("aabcc", "dbbca", "aadbbbaccc"));
    }
}
