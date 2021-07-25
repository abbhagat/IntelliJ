package geeks;

import java.util.Map;
import java.util.TreeMap;

public class SuffixArray {

    public static void main(String[] args) {
        String str = "banana";
        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.substring(i), i);
        }
        map.forEach((k,v) -> System.out.print(k + " " + v));
    }
}
