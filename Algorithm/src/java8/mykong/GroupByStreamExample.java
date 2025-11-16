package java8.mykong;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupByStreamExample {

    public static void main(String[] args) {
        List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");
        Map<String, Long> map = items.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);
        Map<String, Long> finalMap = new LinkedHashMap<>();
        map.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
        System.out.println(finalMap);
        map.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByKey().reversed())
                .forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
        System.out.println(finalMap);
        map.clear();
        map.putAll(finalMap);
        System.out.println(map);
    }
}
