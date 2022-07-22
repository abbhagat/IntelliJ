package vmware;


/*
      Time complexity : O(N)
      Space Complexity: O(1)
 */
public class PalindromeIndexing {

    private static int palindromeIndexing(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                if (s.charAt(i + 1) == s.charAt(j) && s.charAt(i + 2) == s.charAt(j - 1)) {
                    return i;
                }
                if (s.charAt(i) == s.charAt(j - 1)) {
                    return j;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Palindrome Index :- " + palindromeIndexing("MADAM"));
        System.out.println("Palindrome Index :- " + palindromeIndexing("MAXDAM"));
        System.out.println("Palindrome Index :- " + palindromeIndexing("MAXcghDAM"));
    }
}
