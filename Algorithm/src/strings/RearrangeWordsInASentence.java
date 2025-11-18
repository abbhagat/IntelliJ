package strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RearrangeWordsInASentence {

  public static StringBuilder arrangeWords(String text) {
    String[] str = text.split(" ");
    Map<Integer, List<String>> map = new TreeMap<>();
    for (String s : str) {
      map.computeIfAbsent(s.length(), k -> new ArrayList<>()).add(s.toLowerCase());
    }
    StringBuilder sb = new StringBuilder();
    for (Map.Entry<Integer, List<String>> set : map.entrySet()) {
      for (String s : set.getValue()) {
        sb.append(s).append(" ");
      }
    }
    sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
    return sb;
  }

  public static void main(String[] args) {
    System.out.println(arrangeWords("Thirty days challenge"));
  }
}
