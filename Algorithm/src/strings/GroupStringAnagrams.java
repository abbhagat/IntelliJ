package strings;

import java.util.*;

public class GroupStringAnagrams {

    private static List<List<String>> groupAnagrams(String[] str) {
        if (str.length == 0) {
            return null;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : str) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }
            map.get(key).add(s);
        }
        List<List<String>> list = new ArrayList<>();
        list.addAll(map.values());
        return list;
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
