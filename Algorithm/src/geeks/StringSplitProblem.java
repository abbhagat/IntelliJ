package geeks;

import java.util.Map;
import java.util.TreeMap;

public class StringSplitProblem {

  private static String solve(String s1, String s2, String s3) {
    StringBuilder sb = new StringBuilder();
    String[] str = s1.split(s3);
    boolean flag = true;
    for (String s : str) {
      if (s.length() < s2.length()) {
        continue;
      }
      Map<Character, Integer> treeMap = new TreeMap<>();
      s.chars().forEach(c -> treeMap.put((char) c, treeMap.getOrDefault((char) c, 0) + 1));
      Map<Character, Integer> map = new TreeMap<>();
      s2.chars().forEach(c -> map.put((char) c, map.getOrDefault((char) c, 0) + 1));
      for (int i = 0; i < s2.length(); i++) {
        if (treeMap.get(s2.charAt(i)) == null || treeMap.get(s2.charAt(i)) < map.get(s2.charAt(i))) {
          flag = false;
          break;
        }
      }
      if (flag) {
        sb.append(s).append(" ");
      }
    }
    return sb.toString().trim();
  }

  public static void main(String[] args) {
    System.out.println(solve("spqrstrupvsqw", "sprt", "q"));
    System.out.println(solve("spqrstrupvswq", "rstu", "p"));
  }
}
