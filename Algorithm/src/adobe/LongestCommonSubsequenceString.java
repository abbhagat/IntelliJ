package adobe;

import static java.lang.Integer.max;

public class LongestCommonSubsequenceString {

  // Time Complexity  : O(2^(m+n))
  // Space Complexity : O(m+n)
  private static String lcs(String s1, String s2, int m, int n) {
    if (m == 0 || n == 0) {
      return "";
    }
    if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
      return lcs(s1, s2, m - 1, n - 1) + s1.charAt(m - 1);
    }
    String left = lcs(s1, s2, m - 1, n);
    String right = lcs(s1, s2, m, n - 1);
    return left.length() >= right.length() ? left : right;
  }

  // Time  Complexity : O(m*n)
  // Space Complexity : O(m*n)
  private static String lcs(String s1, String s2) {
    int m = s1.length(), n = s2.length();
    String[][] dp = new String[m + 1][n + 1];
    for (int i = 0; i <= m; i++) {
      dp[i][0] = "";
    }
    for (int j = 0; j <= n; j++) {
      dp[0][j] = "";
    }
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1);
        } else {
          dp[i][j] = dp[i - 1][j].length() >= dp[i][j - 1].length() ? dp[i - 1][j] : dp[i][j - 1];
        }
      }
    }
    return dp[m][n];
  }

  public static void main(String[] args) {
    System.out.println(lcs("cat", "cut",    3, 3) + "\t" + lcs("cat", "cut"));
    System.out.println(lcs("geek", "gesek", 4, 5) + "\t" + lcs("geek", "gesek"));
  }

}
