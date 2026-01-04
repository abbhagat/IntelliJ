package strings;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

// Time  Complexity : O(N × L)
// Space Complexity : O(N)
public class GroupStringAnagrams {

  private static Collection<List<String>> groupAnagram(List<String> list) {
    Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
    list.forEach(str -> {
      Map<Character, Integer> freqMap = new HashMap<>();
      str.chars().forEach(c -> freqMap.merge((char) c, 1, Integer::sum));
      map.computeIfAbsent(freqMap, k -> new ArrayList<>()).add(str);
    });
    return map.values();
  }

  public static void main(String[] args) {
    System.out.println(groupAnagram(List.of("eat", "tea", "tan", "ate", "nat", "bat")));
  }
}
