package geeks;

import java.util.LinkedHashMap;
import java.util.Map;

public class CheckCharCanBeReArrangedToFormPalindrome {

    private static boolean canFormPalindrome(String s) {
        int[] temp = new int[128];
        for (char c : s.toCharArray()) {
            temp[c]++;
        }
        int count = 0;
        for (int n : temp) {
            if (n % 2 == 1) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean canFormPalindromeUsingMap(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        s.chars().forEach(c -> map.put((char) c, map.getOrDefault((char) c, 0) + 1));
        int count = 0;
        for (int n : map.values()) {
            if (n % 2 == 1) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println((canFormPalindrome("geeksforgeeks") ? "Can" : "Cannot") + " Form Palindrome");
        System.out.println((canFormPalindrome("geeksogeeks") ? "Can" : "Cannot") + " Form Palindrome");
        System.out.println((canFormPalindromeUsingMap("geeksforgeeks") ? "Can" : "Cannot") + " Form Palindrome");
        System.out.println((canFormPalindromeUsingMap("geeksogeeks") ? "Can" : "Cannot") + " Form Palindrome");
    }
}
