package strings;

import java.util.*;

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

    private static Set<String> set = new HashSet<>();

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
        String str = "abcd";
        permute(str.length() - 1, str);
        System.out.println(set);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                list.add(str.substring(i, j));
            }
        }
        Collections.sort(list);
        System.out.println(list);
    }
}
