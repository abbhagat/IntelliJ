package jpmorgan;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Integer.min;

// Time  Complexity: O(n log n)
// Space Complexity: O(n)
public class TopKFrequentElementsInAnArray {

    private static int[] topKFrequent(int[] a, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : a) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> sortedList = map.entrySet()
                                                          .stream()
                                                          .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                                                          .toList();
        List<Map.Entry<Integer, Integer>> topKList = sortedList.subList(0, min(k, sortedList.size()));
        topKList.forEach(entry -> System.out.print(entry.getKey() + " "));
        System.out.println();
        return topKList.stream()
                       .map(Map.Entry::getKey)
                       .mapToInt(Integer::intValue)
                       .toArray();
    }

    private static String[] topKFrequentWords(List<String> list) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (String x : list) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        List<Map.Entry<String, Integer>> sortedList = map.entrySet()
                                                         .stream()
                                                         .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                                                         .toList();
        sortedList.forEach(entry -> System.out.println(entry.getKey()));
        return sortedList.stream()
                .map(Map.Entry::getKey)
                .toArray(String[]::new);
    }

    public static void main(String[] args) {
        for (int x : topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)) {
            System.out.print(x + " ");
        }
        System.out.println();
        List<String> list = new ArrayList<>(List.of("Abhinaw", "Amit", "Aman", "Abhinaw", "Ankit", "Abhinaw", "Ankit"));
        list.sort(String::compareTo);
        for (String s : topKFrequentWords(list)) {
            System.out.print(s + " ");
        }
    }
}
