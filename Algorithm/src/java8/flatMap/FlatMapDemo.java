package java8.flatMap;

import java.util.*;
import java.util.stream.IntStream;

// Collection::stream = x -> x.stream(), x = List<String> means it is a Collection
public class FlatMapDemo {

    public static void main(String[] args) {
        Map<String, List<String>> people = new HashMap<>();
        people.put("E1", Arrays.asList("D1", "D2"));
        people.put("E2", Arrays.asList("D2", "D3"));
        people.put("E3", Arrays.asList("D4", "D5"));
        Collection<List<String>> deptList = people.values();
        System.out.println(deptList);
        List<String> deptList1 = people.values()
                                       .stream()
                                       .flatMap(Collection::stream)
                                       .toList();
        List<String> deptList2 = people.values()
                                       .stream()
                                       .flatMap(list -> list.stream())
                                       .toList();
        deptList1.forEach(System.out::println);
        deptList2.forEach(System.out::println);

        Map<String, String> map = new LinkedHashMap<>();
        map.put("John", "555-1123");
        map.put("Mary", "555-2243");
        map.put("Steve", "555-6654");
        new ArrayList<>(map.values()).forEach(System.out::println);

        String[][]        dataArray = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}, {"g", "h"}};
        List<String> listOfAllChars = Arrays.stream(dataArray)
//                                          .flatMap(Arrays::stream)
                                            .flatMap(s -> Arrays.stream(s))
                                            .toList();
        System.out.println(listOfAllChars);

        int[] a = {1, 2, 3, 4, 5};
        IntStream integerStream = Arrays.stream(a);
        integerStream.forEach(System.out::println);
    }
}
