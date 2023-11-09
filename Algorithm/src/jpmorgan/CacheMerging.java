package jpmorgan;

import java.util.LinkedHashMap;
import java.util.Map;

public class CacheMerging {

    private static final Map<Integer, Integer> map = new LinkedHashMap<>();

    private static void mergeCache(int x, int y) {
        for (Map.Entry<Integer, Integer> set : map.entrySet()) {
            int start = set.getKey();
            int end = start + set.getValue();
            if (x >= start && x <= end) {
                x = start;
            }
        }
        map.put(x, y);
    }

    public static void main(String[] args) {
        mergeCache(50, 2);
        mergeCache(60, 5);
        mergeCache(51, 7);
        mergeCache(61, 10);
        mergeCache(1, 60);
        map.forEach((k, v) -> System.out.println(k + "-" + v));
    }
}
