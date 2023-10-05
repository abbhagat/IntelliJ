package dynamicProgramming;

import static java.lang.Integer.min;

/**
 * Given a string str, a partitioning of the string is a palindrome partitioning if every sub-string of the partition is a palindrome.
 * Determine the fewest cuts needed for palindrome partitioning of the given string.
 * Input: str = "ababbbabbababa"
 * Output: 3
 * Explanation: After 3 partitioning substrings
 * are "a", "babbbab", "b", "ababa".
 *
 * Input: str = "aaabba"
 * Output: 1
 * Explanation: The substrings after 1
 * partitioning are "aa" and "abba".
 *
 */

public class PalindromePartitioning {

    private static boolean isPalindrome(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    private static int minPalindromePartition(String str, int low, int high) {
        if (low >= high || isPalindrome(str, low, high)) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = low; i < high; i++) {
            int result = 1 + minPalindromePartition(str, low, i) + minPalindromePartition(str, i + 1, high);
            min = min(min, result);
        }
        return min;
    }

    public static void main(String[] args) {
        String str = "ababbbabbababa";
        System.out.println(minPalindromePartition(str, 0, str.length() - 1));
        str = "abcde";
        System.out.println(minPalindromePartition(str, 0, str.length() - 1));
        str = "abbac";
        System.out.println(minPalindromePartition(str, 0, str.length() - 1));
        str = "geek";
        System.out.println(minPalindromePartition(str, 0, str.length() - 1));
        str = "aaaa";
        System.out.println(minPalindromePartition(str, 0, str.length() - 1));
        str = "aaabba";
        System.out.println(minPalindromePartition(str, 0, str.length() - 1));
    }
}
