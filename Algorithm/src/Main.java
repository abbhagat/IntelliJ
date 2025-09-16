import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("A", "65");
        map.put("B", "66");
        System.out.println(map);

        Map<String, String> map1 = new HashMap<>();
        for(String s : "A B C D".split(" ")) {
            map1.computeIfAbsent(s, k -> String.valueOf((int) s.charAt(0)));
        }
        System.out.println(map1);
    }
}
