package java8.flatMap;

import java.util.*;

import static util.CommonUtils.printArray;

// Collection::stream = list -> list.stream(), x = List<String> means it is a Collection
// Arrays::stream     = s -> Arrays.stream(s)
public class FlatMapDemo {

    public static void main(String[] args) {
        Map<String, List<String>> people = new HashMap<>();
        people.put("E1", List.of("D1", "D2"));
        people.put("E2", List.of("D2", "D3"));
        people.put("E3", List.of("D4", "D5"));

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
        System.out.println(deptList1);
        System.out.println(deptList2);

        Map<String, String> map = new LinkedHashMap<>();
        map.put("John", "555-1123");
        map.put("Mary", "555-2243");
        map.put("Steve", "555-6654");
        System.out.println(map.values());

        String[][] dataArray = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}, {"g", "h"}};
        List<String> listOfAllChars = Arrays.stream(dataArray)
                .flatMap(Arrays::stream)
                .toList();
        System.out.println(listOfAllChars);
        String[] stringArray = Arrays.stream(dataArray)
                .flatMap(Arrays::stream)
                .toArray(String[]::new);
        printArray(stringArray);

        int[][] intArray = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> integerList = Arrays.stream(intArray)
                .flatMapToInt(Arrays::stream)
                .boxed()
                .toList();
        System.out.println(integerList);
        int[] integerArray = Arrays.stream(intArray)
                .flatMapToInt(Arrays::stream)
                .toArray();
        System.out.println(Arrays.toString(integerArray));
    }
}
