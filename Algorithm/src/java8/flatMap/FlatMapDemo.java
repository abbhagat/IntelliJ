package java8.flatMap;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
     Collection::stream = x -> x.stream(), x = List<String> means it is a Collection
 */
public class FlatMapDemo {

    public static void main(String[] args) {
        Map<String, List<String>> people = new HashMap<>();
        people.put("John", Arrays.asList("555-1123", "555-3389"));
        people.put("Mary", Arrays.asList("555-2243", "555-5264"));
        people.put("Steve", Arrays.asList("555-6654", "555-3242"));
        Collection<List<String>> list = people.values();
        System.out.println(list);
        List<String> phones = people.values()
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        List<String> phones1 = people.values()
                .stream()
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());
        phones1.forEach(System.out::println);
        phones.forEach(System.out::println);
        Map<String, String> map = new LinkedHashMap<>();
        map.put("John", "555-1123");
        map.put("Mary", "555-2243");
        map.put("Steve", "555-6654");
        new ArrayList<>(map.values()).forEach(System.out::println);

        String[][] dataArray = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}, {"g", "h"}};
        List<String> listOfAllChars = Arrays.stream(dataArray)
                                            .flatMap(Arrays::stream)
                                            .collect(Collectors.toList());
        System.out.println(listOfAllChars);

        int[] a = {1, 2, 3, 4, 5};
        IntStream integerStream = Arrays.stream(a);
        integerStream.forEach(System.out::println);
    }
}
