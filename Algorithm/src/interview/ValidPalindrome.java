package interview;

public class ValidPalindrome {

    private static boolean isValidPalindrome(String s) {
        StringBuilder sb = new StringBuilder("");
        for (char x : s.toLowerCase().toCharArray()) {
            if ((x >= 97 && x <= 122) || (x >= 48 && x <= 57)) {
                sb.append(x);
            }
        }
        s = sb.toString();
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValidPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isValidPalindrome("race a car"));
    }
}
