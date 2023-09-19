package geeks;

import static util.IsPalindrome.isPalindrome;

public class ShortestPalindromeStringByAddingZeroOrMoreChars {

    public static void main(String[] args) {
        String s = "Java";
        if (isPalindrome(s)) {
            System.out.println(s);
        } else {
            String str = s;
            for (int i = 0; i < s.length(); i++) {
                str = s.charAt(s.length() - 1 - i) + str;
                if (isPalindrome(str)) {
                    System.out.println(str);
                    break;
                }
            }
        }
    }
}
