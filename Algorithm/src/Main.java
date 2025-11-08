import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static java.lang.Integer.compare;
import static java.lang.Integer.min;
import static util.CommonUtils.printArray;

public class Main {

  private static int[] topKFrequent(int[] a, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    Arrays.stream(a).forEach(x -> map.put(x, map.getOrDefault(x, 0) + 1));
    List<Map.Entry<Integer, Integer>> sortedList = map.entrySet()
                                                      .parallelStream()
                                                      .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                                                      .toList();
    List<Map.Entry<Integer, Integer>> topKList = sortedList.subList(0, min(k, sortedList.size()));
    return topKList.stream()
                   .map(Map.Entry::getKey)
                   .mapToInt(Integer::intValue)
                   .toArray();
  }

  private static int[] topKFrequent(Stream<Integer> intStream, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    List<Integer> result = new ArrayList<>();
    intStream.forEach(n -> {
      map.put(n, map.getOrDefault(n, 0) + 1);
      if (!list.contains(n)) {
        list.add(n);
      }
      list.sort((x, y) -> y.compareTo(x) == 0 ? compare(x, y) : y.compareTo(x));
      IntStream.range(0, min(k, list.size())).forEach(i -> result.add(list.get(i)));
    });
    return result.stream()
                 .mapToInt(Integer::intValue)
                 .toArray();
  }

  public static void main(String[] args) {
    int[] a = topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
    printArray(a);
  }
}
