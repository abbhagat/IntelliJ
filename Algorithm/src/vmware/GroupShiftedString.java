package vmware;

import java.util.*;

public class GroupShiftedString {

  private static Collection<List<String>> groupStrings(List<String> stringList) {
    Map<String, List<String>> map = new HashMap<>();
    stringList.forEach(s -> {
      int offset = s.charAt(0) - 'a';
      StringBuilder key = new StringBuilder();
      for (char x : s.toCharArray()) {
        char c = (char) (x - offset);
        c += (char) (c < 'a' ? 26 : 0);
        key.append(c);
      }
      map.computeIfAbsent(key.toString(), k -> new ArrayList<>()).add(s);
    });
    return map.values();
  }

  public static void main(String[] args) {
    System.out.println(groupStrings(List.of("abc", "bcd", "acef", "xyz", "az", "ba", "a", "z")));
  }
}
