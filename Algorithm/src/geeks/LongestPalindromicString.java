package geeks;

/*
Given a string, find the longest substring which is palindrome.

For example,

Input: Given string :"forgeeksskeegfor",
Output: "geeksskeeg"

Input: Given string :"Geeks",
Output: "ee"
 */
public class LongestPalindromicString {

    private static int longestPalSubstr(String str) {
        int n = str.length();
        boolean table[][] = new boolean[n][n];
        int maxLength = 1;  // All substrings of length 1 are palindromes
        for (int i = 0; i < n; i++) {
            table[i][i] = true;
        }
        int start = 0;  // check for sub-string of length 2
        for (int i = 0; i < n - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                table[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        for (int k = 3; k <= n; k++) {                          // Check for lengths greater than 2  is length of substring
            for (int i = 0; i < n - k + 1; i++) {              // Fix the starting index
                int j = i + k - 1;                            // Get the ending index of substring from starting index i and length k
                // checking for sub-string from ith index to index if str.charAt(i+1) to str.charAt(j-1) is a palindrome
                if (table[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
                    table[i][j] = true;
                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }
        System.out.print("Longest palindrome substring is : " + str.substring(start, start + maxLength));
        return maxLength;
    }

    public static void main(String[] args) {
        String str = "babad";
        System.out.println("\nLength is: " + longestPalSubstr(str));
    }
}
