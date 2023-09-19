package dynamicProgramming;

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

    public static int LCS(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                dp[i][j] = str1.charAt(i - 1) == str2.charAt(j - 1) ? 1 + dp[i - 1][j - 1] : Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n][m];
    }

    private static int minDistance(String word1, String word2) {
        int lcs = LCS(word1, word2);
        int del = word1.length() - lcs;   // no. of deletions
        int ins = word2.length() - lcs;  // no. of insertions
        return ins + del;
    }

    public static void main(String[] args) {
        System.out.println(minDistance("cat", "cut"));
        System.out.println(minDistance("geek", "gesek"));
        System.out.println(minDistance("sunday", "saturday"));
        System.out.println(minDistance("ros", "horse"));
        System.out.println(minDistance("sea", "eat"));
        System.out.println(minDistance("sea", "eat"));
        System.out.println(minDistance("leetcode", "etco"));
    }

}
