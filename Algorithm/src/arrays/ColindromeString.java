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

    private static boolean isColindromeString(String s) {
        if (s.length() % 6 == 0) {
            for (int i = 0, j = 3; i < s.length() && j < s.length(); i += 6, j = i + 3) {
                String s1 = s.substring(i, j);
                String s2 = new StringBuffer(s.substring(j, j + 3)).reverse().toString();
                if (!s1.equals(s2)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isColindromeString("mollomaappaa111") ? "ColindromeString" : "Not ColindromeString");
        System.out.println(isColindromeString("cappaccappac") ? "ColindromeString" : "Not ColindromeString");
        System.out.println(isColindromeString("mollomaappaa") ? "ColindromeString" : "Not ColindromeString");
    }
}
