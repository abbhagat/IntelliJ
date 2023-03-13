package arrays;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DisplayAllOccuranceOfEnteredStringCaseInsensitive {

    public static void main(String[] args) {
        Map<String, Integer> map = new ConcurrentHashMap<>();
        String[] str = {"Good", "word", "good", "woRd"};
        for (String s : str) {
            map.put(s.toLowerCase(), map.getOrDefault(s.toLowerCase(), 0) + 1);
        }
        String s = "good";
        System.out.println((map.get(s.toLowerCase()) == null) ? (s + " 0") : (s + " " + map.get(s.toLowerCase())));
    }
}
