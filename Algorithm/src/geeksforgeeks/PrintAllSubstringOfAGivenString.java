package geeksforgeeks;

import java.util.Set;
import java.util.TreeSet;

/*
Given a string as an input. We need to write a program that will print all non-empty substrings of that given string.
	Input :  abcd
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

// Time Complexity   O(n)
// Space Complexity  O(n)

public class PrintAllSubstringOfAGivenString {
    private static Set<String> printAllSubstring(String s) {
        Set<String> set = new TreeSet<>(String::compareTo);
        for (int i = 0; i < s.length(); i++) {
            set.add(String.valueOf(s.charAt(i)));
            set.add(s.substring(i));
            set.add(s.substring(0, i));
            if (i < s.length() - 1) {
                set.add(s.substring(i, s.length() - 1));
            }
        }
        return set;
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
    }
}
