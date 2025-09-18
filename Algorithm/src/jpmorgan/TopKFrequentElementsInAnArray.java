package jpmorgan;

import java.util.*;
import static java.lang.Integer.min;
import static util.CommonUtils.printArray;

// Time  Complexity: O(n log n)
// Space Complexity: O(n)
public class TopKFrequentElementsInAnArray {

    private static int[] topKFrequent(int[] a, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(a).forEach(n -> map.put(n, map.getOrDefault(n, 0) + 1));
        List<Map.Entry<Integer, Integer>> sortedList = map.entrySet()
                                                          .stream()
                                                          .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                                                          .toList();
        List<Map.Entry<Integer, Integer>> topKList = sortedList.subList(0, min(k, sortedList.size()));
        return topKList.stream()
                       .map(entry -> entry.getKey())
                       .mapToInt(x -> x.intValue())
                       .toArray();
    }

    private static String[] topKFrequentWords(List<String> list, int k) {
        Map<String, Integer> map = new LinkedHashMap<>();
        list.forEach(s -> map.put(s, map.getOrDefault(s, 0) + 1));
        List<Map.Entry<String, Integer>> sortedList = map.entrySet()
                                                         .stream()
                                                         .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                                                         .toList();
        List<Map.Entry<String, Integer>> topKList = sortedList.subList(0, min(k, sortedList.size()));
        return topKList.stream()
                       .map(Map.Entry::getKey)
                       .toArray(String[]::new);
    }

    public static void main(String[] args) {
        int[] a = topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        printArray(a);
        List<String> list = new ArrayList<>(List.of("Abhinaw", "Amit", "Aman", "Abhinaw", "Ankit", "Abhinaw", "Ankit"));
        list.sort(String::compareTo);
        printArray(topKFrequentWords(list, 1));
    }
}
