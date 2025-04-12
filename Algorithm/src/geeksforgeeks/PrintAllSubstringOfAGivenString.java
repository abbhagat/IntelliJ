package geeksforgeeks;

import java.util.LinkedHashSet;
import java.util.Set;

/*
Given a string as an input. We need to write a program that will print all non-empty substrings of that given string.
Input  :  abcd
Output :  a
          b
          c
          d
          ab
          bc
          cd
          abc
          bcd
          abcd

Input :  abc
          a
          b
          c
          ab
          bc
          abc
 */

// Time  Complexity: O(n^2)
// Space Complexity: O(n^2)
public class PrintAllSubstringOfAGivenString {

    private static Set<String> printAllSubstring(String s) {
        Set<String> set = new LinkedHashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(String.valueOf(s.charAt(i)));
            set.add(s.substring(i));
            set.add(s.substring(0, i));
            set.add(s.substring(i, s.length() - 1));
        }
        return set;
    }

    public static void printAllSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                System.out.println(s.substring(i, j));
            }
        }
    }

    public static void main(String[] args) {
        Set<String> set = printAllSubstring("abc");
        set.stream().filter(s -> !s.isEmpty()).forEach(System.out::println);
        System.out.println();
        set = printAllSubstring("abcd");
        set.stream().filter(s -> !s.isEmpty()).forEach(System.out::println);
        System.out.println();
        set = printAllSubstring("LEETCODE");
        set.stream().filter(s -> !s.isEmpty()).forEach(System.out::println);

        printAllSubstrings("abc");
    }
}
