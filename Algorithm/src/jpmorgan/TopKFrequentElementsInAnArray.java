package jpmorgan;

import java.util.*;

import static java.lang.Integer.min;
import static util.CommonUtils.printArray;

// Time  Complexity: O(n log n)
// Space Complexity: O(n)
public class TopKFrequentElementsInAnArray {

  private static int[] topKFrequent(int[] a, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    Arrays.stream(a).forEach(x -> map.put(x, map.getOrDefault(x, 0) + 1));
    List<Map.Entry<Integer, Integer>> sortedList = map.entrySet()
        .stream()
        .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
        .toList();
    List<Map.Entry<Integer, Integer>> topKList = sortedList.subList(0, min(k, sortedList.size()));
    int[] res = new int[topKList.size()];
    int i = 0;
    for (Map.Entry<Integer, Integer> entry : topKList) {
      res[i] = entry.getKey();
      i++;
    }
    printArray(res);
    return topKList.stream()
        .map(Map.Entry::getKey)
        .mapToInt(x -> x)
        .toArray();
  }

  private static String[] topKFrequentWords(List<String> list, int k) {
    Map<String, Integer> map = new HashMap<>();
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

  public static void topKFreqElements(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    Arrays.stream(nums).forEach(x -> map.put(x, map.getOrDefault(x, 0) + 1));
    PriorityQueue<Integer> pq = new PriorityQueue<>(  //  Min-heap based on frequency
        (a, b) -> {
          int n = map.get(a).compareTo(map.get(b));
          if (n == 0) {
            return b.compareTo(a); // reverse for tie (optional)
          }
          return n;
        }
    );
    for (int num : map.keySet()) {
      pq.offer(num);
      if (pq.size() > k) {
        pq.poll(); // remove least frequent
      }
    }
    List<Integer> list = new ArrayList<>(pq);
    list.sort((a, b) -> map.get(b) - map.get(a));
    System.out.println(list);
  }

  public static void main(String[] args) {
    int[] a = topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
    printArray(a);
    topKFreqElements(new int[]{1, 1, 1, 2, 2, 3}, 2);
    List<String> list = new ArrayList<>(List.of("Abhinaw", "Amit", "Aman", "Abhinaw", "Ankit", "Abhinaw", "Ankit"));
    list.sort(String::compareTo);
    printArray(topKFrequentWords(list, 1));
  }
}
