package geeks;

import java.util.*;

public class SuffixArray {

    public static void main(String[] args) {
        String str = "banana";
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            list.add(str.substring(i));
            map.put(str.substring(i), i);
        }
        Collections.sort(list);
        list.forEach(s -> System.out.print(map.get(s) + " "));
    }
}
