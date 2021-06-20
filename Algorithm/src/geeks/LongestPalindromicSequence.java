package geeks;

/*
As another example, if the given sequence is “BBABCBCAB”, then the output should be 7 as “BABCBAB”
is the longest palindromic subsequence in it. “BBBBB” and “BBCBB” are also palindromic subsequences
of the given sequence, but not the longest ones.
The naive solution for this problem is to generate all subsequences of the given sequence and find
the longest palindromic subsequence. This solution is exponential in term of time complexity
*/
public class LongestPalindromicSequence {

    private static int lps(char[] seq, int i, int j) {
        if (i == j) {  // If there is only one character in the array it is palindrome
            return 1;
        }
        if (seq[i] == seq[j] && i + 1 == j) { // if there are 2 char and both are same
            return 2;
        }
        if (seq[i] == seq[j]) {   // if 1st and last char are same
            return lps(seq, i + 1, j - 1) + 2;
        }
        return Math.max(lps(seq, i + 1, j), lps(seq, i, j - 1)); // If the first and last characters do not match
    }

    public static void main(String[] args) {
        char[] seq = "GEEKSFORGEEKS".toCharArray();
        System.out.println("The length of the LPS is " + lps(seq, 0, seq.length - 1));
    }
}
