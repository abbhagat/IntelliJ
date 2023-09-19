package util;

public class IsPalindrome {

    public static boolean isPalindrome(String s) {
        int j = s.length() - 1;
        for (int i = 0; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
