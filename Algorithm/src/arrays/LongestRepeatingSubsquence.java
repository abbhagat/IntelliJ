package amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LongestRepeatingSubsquence {

    public static Map<String, Integer> longestRepeatingSubsequence(String str) {
        char[] c = str.toCharArray();
        Map<String, Integer> map = new HashMap<>();
        String s = "" + c[0];
        Integer k;
        for (int i = 1; i < c.length; i++) {
            int diff = c[i] - c[i - 1];
            if (diff == 1) {
                s += c[i];
            } else {
                if (diff == 0) {
                    continue;
                }
                k = map.get(s) == null ? map.put(s, 1) : map.put(s, map.get(s) + 1);
                s = "" + c[i];
            }
        }
        k = map.get(s) == null ? map.put(s, 1) : map.put(s, map.get(s) + 1);
        return map;
    }

    public static void main(String[] args) {
        Map<String, Integer> hm = longestRepeatingSubsequence("abcxyzabcmnoabcxyzzzzzzabczzzzzzpqrijklxyz");
        Set<Map.Entry<String, Integer>> set = hm.entrySet();
        String s = null, str = null;
        int max = 0;
        for (Map.Entry<String, Integer> map : set) {
            s += map.getKey() + "->" + map.getValue() + " ";
            if (max < map.getValue()) {
                str = map.getKey();
                max = map.getValue();
            }
        }
        System.out.println(s);
        System.out.println(str + " " + max);
    }
}
