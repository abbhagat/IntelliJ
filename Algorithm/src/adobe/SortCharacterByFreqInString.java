package adobe;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import static java.lang.Integer.max;

public class SortCharacterByFreqInString {

  private static StringBuilder sortCharByFreq(String str) {
    Map<Character, Integer> sortedMap = new LinkedHashMap<>();
    Map<Character, Integer> map = new HashMap<>();
    str.chars()
       .mapToObj(c -> (char) c)
       .forEach(c -> map.put(c, map.getOrDefault(c, 0) + 1));
    map.entrySet()
       .stream()
       .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
       .forEachOrdered(e -> sortedMap.put(e.getKey(), e.getValue()));
    StringBuilder result = new StringBuilder();
    sortedMap.forEach((k, v) -> result.append(String.valueOf(k).repeat(v)));
    return result;
  }

  public static void main(String[] args) {
    System.out.println(sortCharByFreq("tree"));     // eert
    System.out.println(sortCharByFreq("cccaaa"));  //  aaaccc
    System.out.println(sortCharByFreq("Aabb"));   //  "bbAa"
  }
}
