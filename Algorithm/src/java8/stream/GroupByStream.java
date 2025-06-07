package java8.stream;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupByStream {

    public static void main(String[] args) {
        List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");
        Map<String, Long> map = items.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);

        Map<String, Long> finalMap = new LinkedHashMap<>();

        //Sort a map and add to finalMap
        map.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
        System.out.println(finalMap);
        System.out.println(map);
        map = map.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println(map);

    }
}
