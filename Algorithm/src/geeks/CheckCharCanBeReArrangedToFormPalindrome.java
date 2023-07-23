package geeks;

import java.util.HashMap;
import java.util.Map;

public class CheckCharCanBeReArrangedToFormPalindrome {

    private static boolean canFormPalindrome(String s) {
        int[] temp = new int[128];
        for (char c : s.toCharArray()) {
            temp[c]++;
        }
        int count = 0;
        for (int x : temp) {
            if (x % 2 != 0) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean canFormPalindromeUsingMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
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
        System.out.println(canFormPalindrome        ("geeksforgeeks") ? "Can Form Palindrome" : "Cannot Form Palindrome");
        System.out.println(canFormPalindrome        ("geeksogeeks"  ) ? "Can Form Palindrome" : "Cannot Form Palindrome");
        System.out.println(canFormPalindromeUsingMap("geeksforgeeks") ? "Can Form Palindrome" : "Cannot Form Palindrome");
        System.out.println(canFormPalindromeUsingMap("geeksogeeks"  ) ? "Can Form Palindrome" : "Cannot Form Palindrome");
    }
}
