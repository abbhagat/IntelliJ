package recursion;

// Time Complexity  O(n log n)
public class LongestPalindromeFinder {

    public static String intermediatePalindrome(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }

    public static String longestPalindromeString(String s) {
        String longest = s.substring(0, 1), palindrome;
        for (int i = 0; i < s.length(); i++) {
            palindrome = intermediatePalindrome(s, i, i);                                    // odd cases like 121
            longest    = palindrome.length() > longest.length() ? palindrome : longest;
            palindrome = intermediatePalindrome(s, i, i + 1);                        // even cases like 1221
            longest    = palindrome.length() > longest.length() ? palindrome : longest;
        }
        return longest;
    }

    public static void main(String[] args) {
      System.out.println(longestPalindromeString("forgeeksskeegfor"));
      System.out.println(longestPalindromeString("geeks"));
      System.out.println(longestPalindromeString("geeksfskeeg"));
      System.out.println(longestPalindromeString("hackerrekcahba"));
      System.out.println(longestPalindromeString("BBABCBCAB"));
    }
}
