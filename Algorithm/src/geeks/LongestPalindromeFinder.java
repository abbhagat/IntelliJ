package geeks;

public class LongestPalindromeFinder {

    public static String intermediatePalindrome(String s, int left, int right) {
        if (left > right) {
            return null;
        }
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public static String longestPalindromeString(String s) {
        if (s == null) {
            return null;
        }
        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length() - 1; i++) {
            String palindrome = intermediatePalindrome(s, i, i);                            //odd cases like 121
            longest = palindrome.length() > longest.length() ? palindrome : longest;
            palindrome = intermediatePalindrome(s, i, i + 1);                        //even cases like 1221
            longest = palindrome.length() > longest.length() ? palindrome : longest;
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeString("forgeeksskeegfor"));
        System.out.println(longestPalindromeString("geeks"));
        System.out.println(longestPalindromeString("geeksfskeeg"));
    }
}
