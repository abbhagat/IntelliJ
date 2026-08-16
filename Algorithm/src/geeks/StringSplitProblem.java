package geeks;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class StringSplitProblem {

  private static String solve(String s1, String s2, String s3) {
    StringBuilder sb = new StringBuilder();
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s2.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    String[] str = s1.split(s3);
    for (String s : str) {
      if (s.length() < s2.length()) {
        continue;
      }
      Map<Character, Integer> freqMap = new HashMap<>();
      for (char c : s.toCharArray()) {
        freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
      }
      boolean flag = true;
      for (Map.Entry<Character, Integer> entry : map.entrySet()) {
        char c = entry.getKey();
        int requiredCount = entry.getValue();
        if (freqMap.getOrDefault(c, 0) < requiredCount) {
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
