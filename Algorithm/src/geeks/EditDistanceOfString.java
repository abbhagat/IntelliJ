package geeks;

import static java.lang.Integer.min;

/*
Given two strings s1 and s2 and below operations that can performed on s1.
Find minimum number of edits (operations) required to convert ‘s1’ into ‘s2’.

Insert
Remove
Replace
All of the above operations are of equal cost.

Examples:

Input:   s1 = "geek", s2 = "gesek"
Output:  1
We can convert s1 into s2 by inserting a 's'.

Input:   s1 = "cat", s2 = "cut"
Output:  1
We can convert s1 into s2 by replacing 'a' with 'u'.

Input:   s1 = "sunday", s2 = "saturday"
Output:  3
Last three and first characters are same.  We basically need to convert "un" to "atur".
This can be done using below three operations.
Replace 'n' with 'r', insert t, insert a
 */
public class EditDistanceOfString {

    private static int editDist(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = s1.charAt(i - 1) == s2.charAt(j - 1) ? dp[i - 1][j - 1] : 1 + minimum(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]);
            }
        }
        return dp[m][n];
    }

    private static int editDist(String s1, String s2, int m, int n) {
        if (m == 0) {  // If first string is empty, the only option is to insert all characters of second string into first
            return n;
        }

        if (n == 0) {  // If second string is empty, the only option is to remove all characters of first string
            return m;
        }
        // If last characters of two strings are same, nothing much to do. Ignore last characters and get count for remaining strings.
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return editDist(s1, s2, m - 1, n - 1);
        }
        // If last characters are not same, consider all three operations on last character of first string,
        // recursively compute minimum cost for all three operations and take minimum of three values.
        return 1 + minimum(editDist(s1, s2, m, n - 1), editDist(s1, s2, m - 1, n), editDist(s1, s2, m - 1, n - 1)); // Insert, Remove, Replace
    }

    private static int minimum(int x, int y, int z) {
        return x < y ? min(x, z) : min(y, z);
    }

    public static void main(String[] args) {
        System.out.println(editDist("cat", "cut")         + "\t" + editDist("cat", "cut", 3, 3));
        System.out.println(editDist("geek", "gesek")      + "\t" + editDist("geek", "gesek", 4, 5));
        System.out.println(editDist("sunday", "saturday") + "\t" + editDist("sunday", "saturday", 6, 8));
        System.out.println(editDist("ros", "horse")       + "\t" + editDist("ros", "horse", 3, 5));
    }
}
