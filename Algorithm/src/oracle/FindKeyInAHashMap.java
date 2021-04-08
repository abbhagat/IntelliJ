package oracle;

import java.util.HashMap;
import java.util.Map;

public class FindKeyInAHashMap {

    public static void main(String[] args) {
        Map<String, String> hm = new HashMap<>();
        hm.put("A", "65");
        hm.put("B", "66");
        hm.put("C", "67");
        hm.put("D", "68");
        hm.put("E", "69");
        hm.put("F", "70");
        System.out.println(hm);
        if (hm.containsKey("C")) {
            hm.remove("C");
            hm.put("C", "C");
        }
        System.out.println(hm);
    }
}
