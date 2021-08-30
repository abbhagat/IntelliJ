package arrays;

/*
A string is said to be colindrome if it has consecutive 3 alphabets
followed by the reverse of these 3 alphabets and so on.

Input : cappaccappac
Output : String is colindrome

Input : mollomaappaa
Output : String is Colindrome

 */
public class ColindromeString {

    private static boolean isPalindrome(String s, int i, int j) {
        while (i <= j && s.charAt(i++) != s.charAt(j--)) {
            return false;
        }
        return true;
    }

    private static boolean isColindromeString(String s) {
        if (s.length() % 6 == 0) {
            for (int i = 0; i < s.length(); i += 6) {
                if (!isPalindrome(s.substring(i, i + 6), 0, 5)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isColindromeString("mollomaappaa111") ? "Colindrome" : "Not Colindrome");
        System.out.println(isColindromeString("cappaccappac") ? "Colindrome" : "Not Colindrome");
        System.out.println(isColindromeString("mollomaappaa") ? "Colindrome" : "Not Colindrome");
    }
}
