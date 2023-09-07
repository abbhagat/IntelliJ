package leetcode;

// Time complexity : O(N)
// Space Complexity: O(1)
public class PalindromeIndexing {

    private static int palindromeIndexing(char[] c) {
        for (int i = 0, j = c.length - 1; i < j; i++, j--) {
            if (c[i] != c[j]) {
                if (c[i + 1] == c[j] && c[i + 2] == c[j - 1]) {
                    return i;
                }
                if (c[i] == c[j - 1]) {
                    return j;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Palindrome Index : " + palindromeIndexing("MADAM".toCharArray()));
        System.out.println("Palindrome Index : " + palindromeIndexing("MAXDAM".toCharArray()));
        System.out.println("Palindrome Index : " + palindromeIndexing("MAXcghDAM".toCharArray()));
    }
}
