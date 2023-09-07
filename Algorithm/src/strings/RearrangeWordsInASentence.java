package strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RearrangeWordsInASentence {

    public static String arrangeWords(String text) {
        String[] str = text.split(" ");
        Map<Integer, List<String>> map = new TreeMap<>();
        for (String s : str) {
            List<String> list = map.containsKey(s.length()) ? map.get(s.length()) : new ArrayList<>();
            list.add(s);
            map.put(s.length(), list);
        }
        String k = "";
        for (Map.Entry<Integer, List<String>> set : map.entrySet()) {
            for (String s : set.getValue()) {
                k += s + " ";
            }
        }
        char[] a = k.trim().toLowerCase().toCharArray();
        a[0] = (char) (a[0] - 32);
        return new String(a);
    }

    public static void main(String[] args) {
        System.out.println(arrangeWords("Thirty days challenge"));
    }
}
