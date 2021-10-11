package oracle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static void findPairs(int[] a, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            int x = a[i] % k;
            int y = k - x;
            if (map.containsKey(y)) {
                for (int j : map.get(y)) {
                    System.out.println(a[j] + "," + a[i]);
                    count++;
                }
            }
            List<Integer> list = map.containsKey(x) ? map.get(x) : new ArrayList<>();
            if (list.isEmpty() || a[list.get(0)] != a[i]) {
                list.add(i);
            }
            map.put(x, list);
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        findPairs (new int[]{2, 2, 1, 7, 5, 3}, 4);
        countPairs(new int[]{2, 2, 1, 7, 5, 3}, 4);
    }

    private static void countPairs(int[] a, int k) {
        int[] freq = new int[k];
        for (int x : a) {
            freq[x % k]++;
        }
        int count = freq[0] * (freq[0] - 1) / 2;
        for (int i = 1; i <= k / 2 && i != k - i; i++) {
            count += freq[i] * freq[k - i];
        }
        if (k % 2 == 0) {
            count += freq[k / 2] * (freq[k / 2] - 1) / 2;
        }
        System.out.println(count);
    }
}
