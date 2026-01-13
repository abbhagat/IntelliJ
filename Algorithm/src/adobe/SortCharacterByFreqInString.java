package adobe;

import java.util.*;
import java.util.stream.IntStream;

public class SortCharacterByFreqInString {

  private static String sortCharByFreq(String str) {
    Map<Character, Integer> map = new HashMap<>();
    StringBuilder sb = new StringBuilder();
    str.chars().forEach(c -> map.put((char) c, map.getOrDefault((char) c, 0) + 1));
    Map<Character, Integer> finalMap = new LinkedHashMap<>();
    map.entrySet()
       .stream()
       .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
       .forEachOrdered(e-> finalMap.put(e.getKey(), e.getValue()));
    finalMap.forEach((k,v) -> IntStream.range(0, v).forEach(i -> sb.append(k)));
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(sortCharByFreq("tree"));     // eert
    System.out.println(sortCharByFreq("cccaaa"));  //  aaaccc
    System.out.println(sortCharByFreq("Aabb"));   //  "bbAa"
  }
}
