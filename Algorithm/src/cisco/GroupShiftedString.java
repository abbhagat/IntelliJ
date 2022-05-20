package cisco;

import java.util.*;

public class GroupShiftedString {

    private static void groupStrings(List<String> list) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : list) {
            int offset = s.charAt(0) - 'a';
            StringBuilder key = new StringBuilder();
            for (char x : s.toCharArray()) {
                char c = (char) (x - offset);
                if (c < 'a') {
                    c += 26;
                }
                key.append(c);
            }
            if (!map.containsKey(key.toString())) {
                List<String> l = new ArrayList<>();
                map.put(key.toString(), l);
            }
            map.get(key.toString()).add(s);
        }
        System.out.println(map.values());
    }

    public static void main(String[] args) {
        groupStrings(Arrays.asList("abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"));
    }
}
