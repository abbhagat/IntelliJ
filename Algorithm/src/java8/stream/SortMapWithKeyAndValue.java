package java8.stream;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortMapWithKeyAndValue {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 65);
        map.put("X", 88);
        map.put("Z", 90);
        map.put("B", 66);
        map.put("Y", 89);
        map.put("C", 67);
        map.put("D", 1);
        System.out.println(map);
        Map<String, Integer> result = map
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        //                              .collect(Collectors.toMap(entry-> entry.getKey(), entry -> entry.getValue()));
        System.out.println(result);
        result = map
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println(result);
    }
}
