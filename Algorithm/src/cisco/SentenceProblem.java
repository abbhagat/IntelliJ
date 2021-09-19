package cisco;

import java.util.*;

public class SentenceProblem {

    public static String arrange(String sentence) {
        TreeMap<Integer, List<String>> map = new TreeMap<>();
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
        Set<Map.Entry<Integer, List<String>>> set = map.entrySet();
        for (Map.Entry<Integer, List<String>> m : set) {
            for (String x : m.getValue()) {
                sb.append(x + " ");
            }
        }
        String result = sb.toString().trim();
        result += ".";
        result = result.toLowerCase();
        char c = result.charAt(0);
        if (c >= 97 && c <= 122) {
            c -= 32;
        }
        return "" + c + result.substring(1);
    }

    public static void main(String[] args) {
        System.out.println(arrange("Java is an OOP."));
    }
}
