package strings;

public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        int i = 1;
        int j = s.length() - 1;
        while (true) {
            if (isPalindrome(s)) {
                System.out.println(s);
                return s;
            }
            if (isPalindrome(s.substring(0, j))) {
                System.out.println(s.substring(0, j));
                return s.substring(0, j);
            }
            if (isPalindrome(s.substring(i))) {
                System.out.println(s.substring(i));
                return s.substring(i);
            }
            if (isPalindrome(s.substring(i, j))) {
                System.out.println(s.substring(i, j));
                return s.substring(i, j);
            }
            i++;
            j--;
        }
    }

    private static boolean isPalindrome(String s) {
        return s.equals(new StringBuffer(s).reverse().toString()) ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aacabdkacaa"));

    }
}
