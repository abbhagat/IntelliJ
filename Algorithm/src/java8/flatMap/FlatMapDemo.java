package java8.flatMap;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapDemo {

    public static void main(String[] args) {
        Map<String, List<String>> people = new HashMap<>();
        people.put("John", Arrays.asList("555-1123", "555-3389"));
        people.put("Mary", Arrays.asList("555-2243", "555-5264"));
        people.put("Steve", Arrays.asList("555-6654", "555-3242"));
        Collection<List<String>> list = people.values();
        System.out.println(list);
        List<String> phones = people.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
        phones.forEach(System.out::println);
        Map<String, String> map = new LinkedHashMap<>();
        map.put("John", "555-1123");
        map.put("Mary", "555-2243");
        map.put("Steve", "555-6654");
        map.values().stream().flatMap(Stream::of).collect(Collectors.toList()).forEach(System.out::println);
    }
}
