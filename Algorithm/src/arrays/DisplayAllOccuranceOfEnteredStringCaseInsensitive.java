package arrays;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DisplayAllOccuranceOfEnteredStringCaseInsensitive {

    public static void main(String[] args) {
        Map<String, Integer> chm = new ConcurrentHashMap<>();
        String[] str = {"Good", "word", "good", "woRd"};
        for (String s : str) {
            Integer k = chm.get(s.toLowerCase()) == null ? chm.put(s.toLowerCase(), 1) : chm.put(s.toLowerCase(), chm.get(s.toLowerCase()) + 1);
        }
        String s = "good";
        System.out.println((chm.get(s.toLowerCase()) == null) ? (s + " 0") : (s + " " + chm.get(s.toLowerCase())));
    }

}
