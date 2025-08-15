package gfg;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SentenceProblem {

    public static String arrange(String sentence) {
        Map<Integer, List<String>> map = new TreeMap<>();
        String[] str = sentence.split(" ");
        for (String s : str) {
            if (!s.isEmpty()) {
                if (s.contains(".")) {
                    s = s.replace(".", "");
                }
                List<String> list = map.containsKey(s.length()) ? map.get(s.length()) : new LinkedList<>();
                list.add(s);
                map.put(s.length(), list);
            }
        }
        StringBuilder sb = new StringBuilder();
        map.forEach((k, v) -> {
            for (String s : v) {
                sb.append(s).append(" ");
            }
        });
        String result = sb.toString().trim();
        result += ".";
        result = result.toLowerCase();
        char c = result.charAt(0);
        if (c >= 97 && c <= 122) {
            c -= 32;
        }
        return c + result.substring(1);
    }

    public static void main(String[] args) {
        System.out.println(arrange("Java is an OOP."));
    }
}
