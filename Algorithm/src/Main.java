import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Integer.min;

public class Main {

    private static final Map<Integer, Integer> map = new LinkedHashMap<>();

    private static void topKFrequent(int x, int k) {
        map.put(x, map.getOrDefault(x, 0) + 1);
        List<Map.Entry<Integer, Integer>> sortedList = map.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .collect(Collectors.toList());
        List<Map.Entry<Integer, Integer>> topKList = sortedList.subList(0, min(k, sortedList.size()));
        ListIterator<Map.Entry<Integer, Integer>> listIterator = topKList.listIterator(topKList.size());
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous().getKey() + " ");
        }
    }

    // Driver program to test above function
    public static void main(String[] args) {
        for (int x : new int[]{5, 2, 1, 3, 2}) {
            topKFrequent(x, 4);
        }
    }
}
