package sorting;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortMapByKeyAndByValues {

    public static <K extends Comparable<K>, V> Map<K, V> sortByKey(Map<K, V> map) {
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.<K, V>comparingByKey().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,     // entry -> entry.getKey()
                        Map.Entry::getValue,  //  entry -> entry.getValue()
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    public static <K, V extends Comparable<V>> Map<K, V> sortByValues(Map<K, V> map) {
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.<K, V>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,     // entry -> entry.getKey()
                        Map.Entry::getValue,  //  entry -> entry.getValue()
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("C", 3);
        map.put("B", 2);
        System.out.println("Original map: " + map);
        System.out.println("Sorted Map By Key  : " + sortByKey(map));
        System.out.println("Sorted Map By Value: " + sortByValues(map));
    }
}
