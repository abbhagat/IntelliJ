package utildemo;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        Map<String, Integer> tm = new TreeMap<>(Comparator.reverseOrder());
        tm.put("A", 99);
        tm.put("X", 90);
        tm.put("M", 85);
        tm.put("N", 93);
        tm.put("O", 97);
        //tm.put(null,66);  // Exception NPE .. TreeMap does not allow null key.
        tm.forEach((k, v) -> System.out.println(k + "\t" + v));
        Map<String, Integer> t = new TreeMap<>();
        t.put("A", null);
        t.put("B", null);
        System.out.println(t);
    }
}
