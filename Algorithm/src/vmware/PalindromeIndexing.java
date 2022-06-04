package vmware;


/*
      Time complexity : O(N)
      Space Complexity: O(1)
 */
public class PalindromeIndexing {

    private static int palindromeIndexing(String s) {
        int j = s.length() - 1;
        for (int i = 0; i <= j / 2; i++) {
            if (s.charAt(i) != s.charAt(j - i)) {
                if (s.charAt(i + 1) == s.charAt(j - i) && s.charAt(i + 2) == s.charAt(j - i - 1)) {
                    return i;
                }
                if (s.charAt(i) == s.charAt(j - i - 1)) {
                    return j - i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Palindrome Index :- " + palindromeIndexing("MAXCFGDAM"));
    }
}
