package geeks;

import java.util.Map;
import java.util.TreeMap;

/**
 * Let the given string be "banana"
 * 0 banana                          5 a
 * 1 anana     Sort the Suffixes     3 ana
 * 2 nana      ---------------->     1 anana
 * 3 ana        alphabetically       0 banana
 * 4 na                              4 na
 * 5 a                               2 nana
 * So the suffix array for "banana" is {5, 3, 1, 0, 4, 2}
 */

public class SuffixArray {

  public static void main(String[] args) {
    String str = "banana";
    Map<String, Integer> map = new TreeMap<>();
    for (int i = 0; i < str.length(); i++) {
      map.put(str.substring(i), i);
    }
    System.out.println(map);
  }
}
