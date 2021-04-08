package goldmansach;

public class ShortestPalindromeStringByAddingZeroOrMoreChars {

    static boolean isPalindrome(String s) {
        int j = s.length() - 1;
        for (int i = 0; i < s.length() / 2; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "Java";
        if (isPalindrome(s)) {
            System.out.println(s);
        } else {
            String str = s;
            for (int i = 0; i < s.length(); i++) {
                str = s.charAt(i) + str;
                if (isPalindrome(str)) {
                    System.out.println(str);
                    break;
                }
            }
        }
    }
}
