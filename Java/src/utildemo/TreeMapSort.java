package utildemo;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

class KeyComparator implements Comparator<String> {

    public int compare(String s1, String s2) {
        return s2.compareTo(s1);
    }
}

class ValueComparator<K, V extends Comparable<V>> implements Comparator<K> {

    private Map<K, V> map;

    public ValueComparator(Map<K, V> map) {
        this.map = map;
    }

    @Override
    public int compare(K k1, K k2) {
        V v1 = map.get(k1);
        V v2 = map.get(k2);
        return v1.compareTo(v2);
    }
}

public class TreeMapSort {
    public static void main(String[] args) {
        Map<String, Integer> tm = new TreeMap<>((s1, s2) -> s2.compareTo(s1));
        tm.put("A", 65);
        tm.put("B", 66);
        tm.put("C", 67);
        tm.put("D", 68);
        tm.put("E", 69);
        System.out.println(tm);
        Map<String, Integer> map = new TreeMap<>();
        map.put("A", 65);
        map.put("B", 66);
        map.put("C", 67);
        map.put("D", 68);
        map.put("E", 69);
        Map<String, Integer> treeMap = new TreeMap<>(new ValueComparator<>(map));
        System.out.println(treeMap);
    }
}
