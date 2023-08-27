package pairs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindPairsInArrayWhoseSumIsDivisibleByGivenNumber {

    private static void findPairs(int[] a, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            int x = a[i] % k;
            int y = k - x;
            if (map.containsKey(y)) {
                for(int j : map.get(y)) {
                    System.out.println(a[i] + "," + a[j]);
                    count++;
                }
            }
            List<Integer> list = map.containsKey(x) ? map.get(x) : new ArrayList<>();
            if (list.isEmpty() || a[list.get(0)] != a[i]) {
                list.add(i);
            }
            map.put(x, list);
        }
        System.out.println("Pair Count : " + count);
    }

    public static void main(String[] args) {
        final int[] a = {2, 2, 1, 7, 5, 3};
        findPairs(a, 4);
        findPairs(a, 8);
    }
}
