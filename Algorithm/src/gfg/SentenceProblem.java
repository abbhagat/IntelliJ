package gfg;

import java.util.*;

public class SentenceProblem {

    public static String arrange(String sentence) {
        Map<Integer, List<String>> map = new TreeMap<>();
        String[] str = sentence.split(" ");
        for (String s : str) {
            if (!s.isEmpty()) {
                if (s.contains(".")) {
                    s = s.replace(".", "");
                }
                map.computeIfAbsent(s.length(), k -> new LinkedList<>()).add(s);
            }
        }
        StringBuilder sb = new StringBuilder();
//        map.values().stream().flatMap(Collection::stream).forEach(s -> sb.append(s).append(" "));
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
