package vmware;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MissingNumber_1_to_25 {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 3, 5};
        int n = a.length, sum1 = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int x : a) {
            map.put(x, map.getOrDefault(x, 0) + 1);
            sum1 += x;
        }
        Set<Map.Entry<Integer,Integer>> entrySet = map.entrySet();
        for(Map.Entry<Integer, Integer> m : entrySet) {
            if(m.getValue() > 1) {
                sum1 -= m.getKey();
                break;
            }
        }
        int sum2 = ((a[0] + a[n - 1]) * n) / 2;
        // int sum2 = ((a[0] + a[n - 1]) * (n + 1)) / 2; when num is not repeated
        System.out.println(sum2 - sum1);
    }
}
