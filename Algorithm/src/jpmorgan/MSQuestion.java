package jpmorgan;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MSQuestion {

    public static void main(String[] args) {
        Stream<String> dataStream = Stream.of("1", "2", "3", "4", "5", "6", "2", "3", "6", "6", "1", "7", "7", "9", "10");
        Map<String, Integer> map = new HashMap<>();
        dataStream.forEach(key -> map.put(key, map.getOrDefault(key, 0) + 1));
        System.out.println(map);
        List<Map.Entry<String, Integer>> list = map.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toList());
        System.out.println(list.get(0).getKey());
    }
}
