package geeks;

/*
Given a string, find the longest substring which is palindrome.

For example,

Input: Given string :"forgeeksskeegfor",
Output: "geeksskeeg"

Input: Given string :"Geeks",
Output: "ee"
 */
public class LongestPalindromicString {

    private static boolean isPalindrome(char[] c) {
        int i = 0, j = c.length - 1;
        while (i < j) {
            if (c[i++] != c[j--]) {
                return false;
            }
        }
        return true;
    }

    private static String findLongestPalindromicString(String str) {
        String maxPalindrome = "", maxPalindrome1 = "", maxPalindrome2 = "", maxPalindrome3 = "";
        for (int i = 0, j = str.length(); i < str.length() && j > 0; i++, j--) {
            if (isPalindrome(str.substring(i).toCharArray())) {
                maxPalindrome1 = str.substring(i);
            }
            if (i < j && isPalindrome(str.substring(i, j).toCharArray())) {
                maxPalindrome2 = str.substring(i, j);
            }
            if (j > 0 && isPalindrome(str.substring(0, j).toCharArray())) {
                maxPalindrome3 = str.substring(0, j);
            }
            maxPalindrome = maxPalindrome1.length() > maxPalindrome.length() ? maxPalindrome1 : maxPalindrome;
            maxPalindrome = maxPalindrome2.length() > maxPalindrome.length() ? maxPalindrome2 : maxPalindrome;
            maxPalindrome = maxPalindrome3.length() > maxPalindrome.length() ? maxPalindrome3 : maxPalindrome;
        }
        return maxPalindrome;
    }

    public static void main(String[] args) {
        System.out.println(findLongestPalindromicString("Geeks"));
    }
}
