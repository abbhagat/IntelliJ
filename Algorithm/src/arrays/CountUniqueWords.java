package arrays;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class CountUniqueWords {

    public static void main(String[] args) {
        String str = "Java is an OOP OOP Java is an the OOP";
        Map<String, Integer> map = new ConcurrentHashMap<>();
        Arrays.stream(str.split(" ")).forEach(s -> map.put(s, map.getOrDefault(s, 0) + 1));
        map.forEach((k, v) -> {
            if (1 == v) {
                System.out.println(k + "\t" + v);
            }
        });
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        for (Map.Entry<String, Integer> m : set) {
            if (m.getValue() == 1) {
                System.out.println(m.getKey() + "\t" + m.getValue());
            }
        }
    }
}
