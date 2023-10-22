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
            List<Integer> list = map.containsKey(x) ? map.get(x) : new ArrayList<>();
            list.add(i);
            map.put(x, list);
        }
        for(int i = 0; i < a.length; i++) {
            int x = a[i] % k;
            int y = k - x;
            if (map.containsKey(y) || (y == 0 &&  map.get(y).size() > 1)) {
                for(int j : map.get(y)) {
                    System.out.println(a[i] + "," + a[j]);
                    count++;
                }
            }
        }
        System.out.println("Pair Count : " + count);
    }

    public static void main(String[] args) {
        int[] a = {2,3,5,10};
        findPairs(a, 5);
    }
}
