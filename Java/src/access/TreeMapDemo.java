package access;

import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap<String,Integer> tm = new TreeMap<>();
        tm.put("A",65);
        tm.put("A",66);
        tm.put("X",88);
        System.out.println(tm);
    }
}
