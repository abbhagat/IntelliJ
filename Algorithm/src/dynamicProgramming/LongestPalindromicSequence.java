package dynamicProgramming;

import static java.lang.Integer.max;

/**
 * As another example, if the given sequence is “BABCBCABB”, then the output should be 7 as “BABCBAB”
 * is the longest palindromic subsequence in it. “BBBBB” and “BBCBB” are also palindromic subsequences
 * of the given sequence, but not the longest ones.
 * The naive solution for this problem is to generate all subsequences of the given sequence and find
 * the longest palindromic subsequence. This solution is exponential in terms of time complexity
 */
public class LongestPalindromicSequence {

  // Time Complexity : O(2^ⁿ)
  private static int lps(char[] c, int low, int high) {
    if (low > high) {
      return 0;
    }
    if (low == high) {
      return 1;
    }
    if (c[low] == c[high]) {  // if 1st and last char are same
      return 2 + lps(c, low + 1, high - 1);
    }
    return max(lps(c, low + 1, high), lps(c, low, high - 1)); // If the first and last characters do not match
  }

  private static int lps(char[] c) {
    int n = c.length;
    int[][] dp = new int[n][n];   // Create a table to store results of sub problems
    for (int i = 0; i < n; i++) {
      dp[i][i] = 1;            // Strings of length 1 are palindrome of length 1
    }
    for (int k = 2; k <= n; k++) {
      for (int i = 0; i < n - k + 1; i++) {
        int j = i + k - 1;
        if (c[i] == c[j]) {
          if (k == 2) {
            dp[i][j] = 2;
          } else {
            dp[i][j] = dp[i + 1][j - 1] + 2;
          }
        } else {
          dp[i][j] = max(dp[i][j - 1], dp[i + 1][j]);
        }
      }
    }
    return dp[0][n - 1];
  }

  public static void main(String[] args) {
    char[] c = "BABCBCABB".toCharArray();
    System.out.println("The length of the LPS is " + lps(c, 0, c.length - 1));
    System.out.println("The length of the LPS is " + lps(c));
  }
}
