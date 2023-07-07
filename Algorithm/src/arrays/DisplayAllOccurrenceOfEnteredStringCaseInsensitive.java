package arrays;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DisplayAllOccurrenceOfEnteredStringCaseInsensitive {

    private static int findAllOccurrence(String[] str, String key) {
        Map<String, Integer> map = new ConcurrentHashMap<>();
        for (String s : str) {
            s = s.toLowerCase();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        return map.getOrDefault(key, 0);
    }

    public static void main(String[] args) {
        System.out.println(findAllOccurrence(new String[]{"Good", "word", "good", "woRd"}, "good"));
    }
}
