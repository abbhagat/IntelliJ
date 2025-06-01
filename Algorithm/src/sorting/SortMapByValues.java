package sorting;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortMapByValues {

    public static <K, V extends Comparable<V>> Map<K, V> sortByValues(Map<K, V> map) {
        return map.entrySet()
                  .stream()
                  .sorted(Map.Entry.<K, V>comparingByValue().reversed())
                  .collect(Collectors.toMap(
                                            Map.Entry::getKey,
                                            Map.Entry::getValue,
                                            (e1, e2) -> e1,
                                            LinkedHashMap::new
                ));
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("Z", 2);
        map.put("C", 3);
        System.out.println("Original map: " + map);
        Map<String, Integer> sortedMap = sortByValues(map);
        System.out.println("Sorted map: " + sortedMap);
    }
}
