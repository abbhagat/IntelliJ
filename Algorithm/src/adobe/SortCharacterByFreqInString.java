package adobe;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import static java.lang.Integer.max;

public class SortCharacterByFreqInString {

  private static String sortCharByFreq(String str) {
    Map<Character, Integer> map = new HashMap<>();
    StringBuilder sb = new StringBuilder();
    Map<Character, Integer> sortedMap = new LinkedHashMap<>();
    str.chars().forEach(c -> map.put((char) c, map.getOrDefault((char) c, 0) + 1));
    map.entrySet()
       .stream()
       .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
       .forEachOrdered(e -> sortedMap.put(e.getKey(), e.getValue()));
    sortedMap.forEach((k, v) -> sb.append(String.valueOf(k).repeat(max(0, v))));
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(sortCharByFreq("tree"));     // eert
    System.out.println(sortCharByFreq("cccaaa"));  //  aaaccc
    System.out.println(sortCharByFreq("Aabb"));   //  "bbAa"
  }
}
