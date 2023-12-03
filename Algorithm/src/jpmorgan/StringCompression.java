package jpmorgan;

import java.util.LinkedHashMap;
import java.util.Map;

public class StringCompression {

    public static String stringCompression(String str) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int index = 0, count = 1;
        map.put(index, count);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                map.put(index, count);
                index = i;
                count = 1;
            }
        }
        map.put(index, count);
        StringBuilder result = new StringBuilder();
        map.forEach((k, v) -> result.append(str.charAt(k)).append(v));
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(stringCompression("ffilllttteeeeerredd"));
        System.out.println(stringCompression("abbcccddddeaaacc"));
        System.out.println(stringCompression("wwwwaaadexxxxxxq"));
    }
}
