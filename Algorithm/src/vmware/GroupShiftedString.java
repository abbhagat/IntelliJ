package vmware;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedString {

  private static void groupStrings(List<String> stringList) {
    Map<String, List<String>> map = new HashMap<>();
    stringList.forEach(s -> {
      int offset = s.charAt(0) - 'a';
      String key = "";
      for (char x : s.toCharArray()) {
        char c = (char) (x - offset);
        c += (char) (c < 'a' ? 26 : 0);
        key += c;
      }
      map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
    });
    System.out.println(map.values());
  }

  public static void main(String[] args) {
    List<String> stringList = List.of("abc", "bcd", "acef", "xyz", "az", "ba", "a", "z");
    groupStrings(stringList);
  }
}
