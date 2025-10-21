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

    private static int lps(char[] seq, int i, int j) {
        if (i == j) {
            return 1;
        }
        if (seq[i] == seq[j] && i + 1 == j) {
            return 2;
        }
        if (seq[i] == seq[j]) {              // if 1st and last char are same
            return lps(seq, i + 1, j - 1) + 2;
        }
        return max(lps(seq, i + 1, j), lps(seq, i, j - 1)); // If the first and last characters do not match
    }

    private static int lps(char[] seq) {
        int n = seq.length;
        int[][] DP = new int[n][n];   // Create a table to store results of sub problems
        for (int i = 0; i < n; i++) {
            DP[i][i] = 1;            // Strings of length 1 are palindrome of length 1
        }
        for (int k = 2; k <= n; k++) {
            for (int i = 0; i < n - k + 1; i++) {
                int j = i + k - 1;
                if (seq[i] == seq[j]) {
                    if (k == 2) {
                        DP[i][j] = 2;
                    } else {
                        DP[i][j] = DP[i + 1][j - 1] + 2;
                    }
                } else {
                    DP[i][j] = max(DP[i][j - 1], DP[i + 1][j]);
                }
            }
        }
        return DP[0][n - 1];
    }

    public static void main(String[] args) {
        char[] seq = "BABCBCABB".toCharArray();
        System.out.println("The length of the LPS is " + lps(seq, 0, seq.length - 1));
        System.out.println("The length of the LPS is " + lps(seq));
    }
}
