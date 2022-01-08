package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StringAnagram {
    public static void main(String[] args) {

        Character[] c1 = {'j', 'a', 'v', 'a'};
        Character[] c2 = {'a', 'j', 'a', 'v'};
        Map<String, Integer> hm = new HashMap<>();
        if (c1.length != c2.length) {
            System.out.println("Not anagram");
        } else {
            for (int i = 0; i < c1.length; i++) {
                String s = c1[i].toString();
                if (hm.get(s) == null) {
                    hm.put(c1[i].toString(), 1);
                } else {
                    int j = hm.get(c1[i].toString());
                    hm.put(c1[i].toString(), ++j);
                }
            }
            Set<Map.Entry<String, Integer>> set = hm.entrySet();
            for (Map.Entry<String, Integer> map : set) {
                System.out.println(map.getKey() + "\t" + map.getValue());
            }
        }
    }
}
