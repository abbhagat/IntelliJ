package vmware;

/**
 * A message containing letters from A-Z can be encoded into numbers using the following mapping:
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * To decode an encoded message, all the c must be grouped then mapped back into letters
 * using the reverse of the mapping above (there may be multiple dp).
 * For example, "11106" can be mapped into:
 * <p>
 * "AAJF" with the grouping (1 1 10 6)
 * "KJF" with the grouping (11 10 6)
 * Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
 * <p>
 * Given a string s containing only c, return the number of dp to decode it.
 * <p>
 * The test cases are generated so that the answer fits in a 32-bit integer.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "12"
 * Output: 2
 * Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 * <p>
 * Input: s = "226"
 * Output: 3
 * Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 * Example 3:
 * <p>
 * Input: s = "06"
 * Output: 0
 * Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").
 * <p>
 * Input:  c[] = "121"
 * Output: 3
 * // The possible decodings are "ABA", "AU", "LA"
 * <p>
 * Input: c[] = "1234"
 * Output: 3
 * // The possible decodings are "ABCD", "LCD", "AWD"
 */

public class NumOfDecodeWays {

    private static int decodeWays(String s) {
        if(s == null || s.isEmpty()) {
            return 0;
        }
        char[] c = s.toCharArray();
        if (c[0] == '0') {   // for base condition "01123" should return 0
            return 0;
        }
        int n = c.length;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = 0;
            if (c[i - 1] > '0') {     // If the last digit is not 0, then last digit must add to the number of words
                dp[i] = dp[i - 1];
            }
            if (c[i - 2] == '1' || (c[i - 2] == '2' && c[i - 1] < '7')) {  // If second last digit is smaller than 2 and last digit is smaller than 7, then last two form a valid character
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(decodeWays("12"));
        System.out.println(decodeWays("226"));
        System.out.println(decodeWays("121"));
        System.out.println(decodeWays("1234"));
    }
}
