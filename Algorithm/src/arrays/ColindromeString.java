package arrays;

/**
A string is said to be colindrome if it has consecutive 3 alphabets
followed by the reverse of these 3 alphabets and so on.

Input : cappaccappac
Output: String is colindrome

Input : mollomaappaa
Output: String is Colindrome

 */
public class ColindromeString {

    private static boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isColindromeString(String s) {
        if (s.length() % 6 == 0) {
            for (int i = 0; i < s.length(); i += 6) {
                if (!isPalindrome(s.substring(i, i + 6))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isColindromeString("mollomaappaa") ? "Colindrome" : "Not Colindrome");
        System.out.println(isColindromeString("cappaccappac") ? "Colindrome" : "Not Colindrome");
        System.out.println(isColindromeString("mollomaapaap") ? "Colindrome" : "Not Colindrome");
    }
}
