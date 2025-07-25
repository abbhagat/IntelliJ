import java.util.*;

import static java.lang.Integer.min;

public class Main {

    private static void topKFrequent(int[] a, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(a).forEach(x -> map.put(x, map.getOrDefault(x, 0) + 1));
        List<Map.Entry<Integer, Integer>> sortedList = map.entrySet()
                                                          .stream()
                                                          .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                                                          .toList();
        List<Map.Entry<Integer, Integer>> topKList = sortedList.subList(0, min(k, sortedList.size()));
        ListIterator<Map.Entry<Integer, Integer>> listIterator = topKList.listIterator(topKList.size());
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous().getKey() + " ");
        }
    }

    public static void main(String[] args) {
        topKFrequent(new int[]{5, 2, 1, 3, 2, 2, 1, 2, 1 , 5}, 2);
    }
}
