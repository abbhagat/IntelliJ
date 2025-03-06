package jpmorgan;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.Integer.min;

public class TopKFrequentElementsInAnArray {

    private static int[] topKFrequent(int[] a, int k) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int x : a) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> sortedList = map.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .collect(Collectors.toList());
        List<Map.Entry<Integer, Integer>> topKList = sortedList.subList(0, min(k, sortedList.size()));
        topKList.forEach(entry -> System.out.print(entry.getKey() + " "));
        System.out.println();
        return topKList.stream()
                .map(Map.Entry::getKey)
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private static void topKFrequentWords(List<String> list) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (String x : list) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        List<Map.Entry<String, Integer>> sortedList = map.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toList());
        sortedList.forEach(entry -> System.out.println(entry.getKey()));
    }

    public static void main(String[] args) {
        for (int x : topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)) {
            System.out.print(x + " ");
        }
        System.out.println();
        List<String> list = new ArrayList<>(List.of("Abhinaw", "Amit", "Aman", "Abhinaw", "Ankit", "Abhinaw", "Ankit"));
        list.sort(String::compareTo);
        topKFrequentWords(list);
    }
}
