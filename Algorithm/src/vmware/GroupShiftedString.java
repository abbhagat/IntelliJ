package vmware;

import java.util.*;

public class GroupShiftedString {

  private static Collection<List<String>> groupStrings(List<String> list) {
    Map<String, List<String>> map = new HashMap<>();
    list.forEach(str -> {
      int offset = str.charAt(0) - 'a';
      StringBuilder key = new StringBuilder(str.length());
      for (char x : str.toCharArray()) {
        char c = (char) (x - offset);
        c += (char) (c < 'a' ? 26 : 0);
        key.append(c);
      }
      map.computeIfAbsent(key.toString(), k -> new ArrayList<>()).add(str);
    });
    return map.values();
  }

  public static void main(String[] args) {
    System.out.println(groupStrings(List.of("abc", "bcd", "acef", "xyz", "az", "ba", "a", "z")));
  }
}
