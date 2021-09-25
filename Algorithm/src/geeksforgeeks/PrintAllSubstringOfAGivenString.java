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

public class PrintAllSubstringOfAGivenString {

    private static Set<String> set = new TreeSet<>(String::compareTo);

    private static void permute(int index, String s) {
        if (index != 0) {
            for (int i = 0; i < s.length(); i++) {
                set.add("" + s.charAt(i));
                set.add(s.substring(i));
                set.add(s.substring(0, i));
                if (i < index) {
                    set.add(s.substring(i, index));
                }
            }
            permute(index - 1, s);
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        permute(str.length() - 1, str);
        set.stream().filter(s -> !s.isEmpty()).forEach(System.out::println);
    }
}
