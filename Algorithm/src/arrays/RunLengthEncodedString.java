package arrays;

import java.util.LinkedHashMap;
import java.util.Map;

public class RunLengthEncodedString {

    public static void main(String[] args) {
        String s = "wwwwaaadexxxxxxq";
        Map<Character, Integer> map = new LinkedHashMap<>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        map.forEach((k,v) -> System.out.print(String.valueOf(k) + v));
    }
}
