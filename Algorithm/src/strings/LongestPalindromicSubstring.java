package strings;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        int i = 1;
        int j = s.length() - 1;
        while (true) {
            if (isPalindrome(s)) {
                return s;
            }
            if (isPalindrome(s.substring(0, j))) {
                return s.substring(0, j);
            }
            if (isPalindrome(s.substring(i))) {
                return s.substring(i);
            }
            if (isPalindrome(s.substring(i, j))) {
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
        String str = "babad";
        String s = longestPalindrome(str);
        Set<String> set = new HashSet<>();
        String k = "";
        for (int i = 0; i < str.length(); i++) {
            k += Character.toString(str.charAt(i));
            if (isPalindrome(k)) {
                set.add(k);
            }
        }
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()){
            String string = iterator.next();
            System.out.println(string.length() > s.length() ? string : s);
            break;
        }
    }
}
