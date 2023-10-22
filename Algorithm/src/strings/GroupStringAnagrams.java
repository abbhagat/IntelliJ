package strings;

import java.util.*;

public class GroupStringAnagrams {

    private static List<List<String>> groupAnagrams(String[] str) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : str) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            List<String> list = map.containsKey(key) ? map.get(key) : new ArrayList<>();
            list.add(s);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    /*
    Time Complexity : Let there be N-words and each word has a maximum of M characters. The upper bound is O(NM).
    Space Complexity: Let there be N-words and each word has maximum M characters, therefore max. storage space for each word with at max.
                      M characters will be O(M), therefore for max N-words, it will be O(N*M). Therefore, the upper bound is O(NM).
    */
    private static List<List<String>> groupAnagrams(List<String> list) {
        Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
        for (String str : list) {
            Map<Character, Integer> tempMap = new HashMap<>();
            for(char c : str.toCharArray()) {
                tempMap.put(c, tempMap.getOrDefault(c, 0) + 1);
            }
            List<String> tempList = map.containsKey(tempMap) ? map.get(tempMap) : new ArrayList<>();
            tempList.add(str);
            map.put(tempMap, tempList);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println();
        System.out.println(groupAnagrams(List.of("eat", "tea", "tan", "ate", "nat", "bat")));
    }
}
