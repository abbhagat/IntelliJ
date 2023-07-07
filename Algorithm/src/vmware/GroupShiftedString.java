package vmware;

import java.util.*;

public class GroupShiftedString {

    private static void groupStrings(List<String> stringList) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : stringList) {
            int offset = s.charAt(0) - 'a';
            String key = "";
            for (char x : s.toCharArray()) {
                char c = (char) (x - offset);
                if (c < 'a') {
                    c += 26;
                }
                key += c;
            }
            List<String> list = map.containsKey(key) ? map.get(key) : new ArrayList<>();
            list.add(s);
            map.put(key, list);
        }
        System.out.println(map.values());
    }

    public static void main(String[] args) {
        groupStrings(Arrays.asList("abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"));
    }
}
