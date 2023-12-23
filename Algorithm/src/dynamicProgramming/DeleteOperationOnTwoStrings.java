package dynamicProgramming;

import static java.lang.Integer.max;

/*
Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.
Example 1:

Input: word1 = "sea", word2 = "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
Example 2:

Input: word1 = "leetcode", word2 = "etco"
Output: 4

The intuition behind this is to find the LCS (Longest Common Subsequence) between the two strings.
The characters that are not part of the LCS need to be deleted in order to make the two strings equal.
By subtracting the LCS count from the total length of the strings, we can determine the characters that need to be deleted.
This approach allows us to calculate the total number of deletions required to achieve string equality.
 */

public class DeleteOperationOnTwoStrings {

    public static int minDistance(String s1, String s2) {
        int lcs = lcs(s1, s2, s1.length(), s2.length());
        int del = s1.length() - lcs;   // no. of deletions
        int ins = s2.length() - lcs;  // no. of insertions
        return ins + del;
    }

    // Time Complexity: O(2^(m*n))
    // Auxiliary Space: O(1)
    public static int lcs(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return 1 + lcs(s1, s2, m - 1, n - 1);
        }
        return max(lcs(s1, s2, m - 1, n), lcs(s2, s2, m, n - 1));
    }

    // Time Complexity: O(m*n)
    // Auxiliary Space: O(1)
    private static int minDistanceDP(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = s1.charAt(i - 1) == s2.charAt(j - 1) ? 1 + dp[i - 1][j - 1] : max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        int lcs = dp[m][n];
        int del = s1.length() - lcs;   // no. of deletions
        int ins = s2.length() - lcs;  // no. of insertions
        return ins + del;
    }

    public static void main(String[] args) {
        System.out.println(minDistance("cat", "cut")         + "\t" + minDistanceDP("cat", "cut"));
        System.out.println(minDistance("geek", "gesek")      + "\t" + minDistanceDP("geek", "gesek"));
        System.out.println(minDistance("sunday", "saturday") + "\t" + minDistanceDP("sunday", "saturday"));
        System.out.println(minDistance("ros", "horse")       + "\t" + minDistanceDP("ros", "horse"));
        System.out.println(minDistance("sea", "eat")         + "\t" + minDistanceDP("sea", "eat"));
        System.out.println(minDistance("etco", "leetcode")   + "\t" + minDistanceDP("etco", "leetcode"));
        System.out.println(minDistance("ace", "abcde")       + "\t" + minDistanceDP("abcde", "ace"));
    }
}
