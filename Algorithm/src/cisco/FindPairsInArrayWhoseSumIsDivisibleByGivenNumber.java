package cisco;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindPairsInArrayWhoseSumIsDivisibleByGivenNumber {

    private static void findPairs(int[] a, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            int x = a[i] % k;
            int y = k - x;
            if (map.containsKey(y)) {
                final int I = i;
                map.get(y).forEach(j -> System.out.println(a[j] + "," + a[I]));
            }
            List<Integer> list = map.containsKey(x) ? map.get(x) : new ArrayList<>();
            if (list.isEmpty() || a[list.get(0)] != a[i]) {
                list.add(i);
            }
            map.put(x, list);
        }
    }

    public static void main(String[] args) {
        findPairs(new int[]{2, 2, 1, 7, 5, 3}, 4);
    }
}
