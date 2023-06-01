package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LongestRepeatingSubsquence {

    public static Map<String, Integer> longestRepeatingSubsequence(String str) {
        char[] c = str.toCharArray();
        Map<String, Integer> map = new HashMap<>();
        String s = String.valueOf(c[0]);
        for (int i = 1; i < c.length; i++) {
            int diff = c[i] - c[i - 1];
            if (diff == 1) {
                s += c[i];
            } else {
                if (diff == 0) {
                    continue;
                }
                map.put(s, map.getOrDefault(s, 0) + 1);
                s = String.valueOf(c[i]);
            }
        }
        map.put(s, map.getOrDefault(s, 0) + 1);
        return map;
    }

    public static void main(String[] args) {
        Map<String, Integer> hm = longestRepeatingSubsequence("abcxyzabcmnoabcxyzzzzzzabczzzzzzpqrijklxyz");
        Set<Map.Entry<String, Integer>> set = hm.entrySet();
        String s = null, str = null;
        int max = 0;
        for (Map.Entry<String, Integer> map : set) {
            System.out.println(map.getKey() + "->" + map.getValue());
            if (max < map.getValue()) {
                str = map.getKey();
                max = map.getValue();
            }
        }
        System.out.println(s);
        System.out.println(str + " " + max);
    }
}
