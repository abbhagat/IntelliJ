package adobe;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class SortCharacterByFreqInString {

  private static String sortCharByFreq(String str) {
    Map<Character, Integer> map = new TreeMap<>();
    StringBuilder sb = new StringBuilder();
    str.chars().forEach(c -> map.put((char) c, map.getOrDefault((char) c, 0) + 1));
    List<Map.Entry<Character, Integer>> list = map.entrySet()
                                                  .stream()
                                                  .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed()).toList();
    list.forEach(entry -> IntStream.range(0, entry.getValue()).forEach(i -> sb.append(entry.getKey())));
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(sortCharByFreq("tree"));     // eert
    System.out.println(sortCharByFreq("cccaaa"));  //  aaaccc
    System.out.println(sortCharByFreq("Aabb"));   //  "bbAa"
  }
}
