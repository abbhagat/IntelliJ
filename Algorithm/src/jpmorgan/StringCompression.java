package jpmorgan;

import java.util.LinkedHashMap;
import java.util.Map;

public class StringCompression {

    public static String compressString(String str) {
        StringBuilder sb = new StringBuilder();
        int index = 0, count = 1;
        sb.append(str.charAt(index));
        for(int i = 1; i < str.length(); i++) {
            if(str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                sb.append(count);
                sb.append(str.charAt(i));
                count = 1;
            }
        }
        sb.append(count);
        return sb.toString();
    }

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
        System.out.println(stringCompression("a") + "\t" + compressString("a"));
        System.out.println(stringCompression("ffilllttteeeeerredd") + "\t" + compressString("ffilllttteeeeerredd"));
        System.out.println(stringCompression("abbcccddddeaaacc")    + "\t" + compressString("abbcccddddeaaacc"));
        System.out.println(stringCompression("wwwwaaadexxxxxxq")    + "\t" + compressString("wwwwaaadexxxxxxq"));
    }
}
