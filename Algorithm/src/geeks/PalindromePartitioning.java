package geeks;

/*
Given a string, a partitioning of the string is a palindrome partitioning if every substring of the partition is a palindrome.
For example, “aba|b|bbabb|a|b|aba” is a palindrome partitioning of “ababbbabbababa”.
Determine the fewest cuts needed for a palindrome partitioning of a given string.
For example, minimum of 3 cuts are needed for “ababbbabbababa”.
The three cuts are “a|babbbab|b|ababa”. If a string is a palindrome, then minimum 0 cuts are needed.
If a string of length n containing all different characters, then minimum n-1 cuts are needed.

Input : str = “geek”
Output : 2
We need to make minimum 2 cuts, i.e., “g ee k”
Input : str = “aaaa”
Output : 0
The string is already a palindrome.
Input : str = “abcde”
Output : 4
Input : str = “abbac”
Output : 1

Using Recursion:-
i is the starting index and j is the ending index. i must be passed as 0 and j as n-1
minPalPartion(str, i, j) = 0 if i == j. // When string is of length 1.
minPalPartion(str, i, j) = 0 if str[i..j] is palindrome.

If none of the above conditions is true, then minPalPartion(str, i, j) can be calculated recursively using the following formula.
minPalPartion(str, i, j) = Min { minPalPartion(str, i, k) + 1 + minPalPartion(str, k+1, j) }  where k varies from i to j-1
 */

import static java.lang.Integer.min;

public class PalindromePartitioning {

    private static boolean isPalindrome(String str, int i, int j) {
        while (i <= j) {
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
            int result = minPalindromePartition(str, low, i) + minPalindromePartition(str, i + 1, high);
            min = min(min, result);
        }
        return min + 1;
    }

    public static void main(String[] args) {
        String str = "ababbbabbababa";
        System.out.println("Min cuts needed for Palindrome Partitioning is " + minPalindromePartition(str, 0, str.length() - 1));
        str = "abcde";
        System.out.println("Min cuts needed for Palindrome Partitioning is " + minPalindromePartition(str, 0, str.length() - 1));
        str = "abbac";
        System.out.println("Min cuts needed for Palindrome Partitioning is " + minPalindromePartition(str, 0, str.length() - 1));
        str = "geek";
        System.out.println("Min cuts needed for Palindrome Partitioning is " + minPalindromePartition(str, 0, str.length() - 1));
        str = "aaaa";
        System.out.println("Min cuts needed for Palindrome Partitioning is " + minPalindromePartition(str, 0, str.length() - 1));
    }
}
