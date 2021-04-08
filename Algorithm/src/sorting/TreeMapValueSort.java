package sorting;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

class MapUtility<K, V> {

    public static <K extends Comparable<K>, V extends Comparable<V>> Map<K, V> sortOnValues(Map<K, V> map) {
        Map<K, V> sortedMap = new TreeMap<>((k1, k2) -> map.get(k1).compareTo(map.get(k2)));
        sortedMap.putAll(map);
        return sortedMap;
    }
}

class ValueComparator<K, V extends Comparable<V>> implements Comparator<K> {

    private Map<K, V> map;

    public ValueComparator(Map<K, V> map) {
        this.map = map;
    }

    public int compare(K k1, K k2) {
        V v1 = map.get(k1);
        V v2 = map.get(k2);
        return v1.compareTo(v2);
    }
}

public class TreeMapValueSort {

	public static void main(String[] args) {
        Map<String, Integer> tm = new TreeMap<>();
        tm.put("A", 1);
        tm.put("Z", 2);
        tm.put("C", 3);
        System.out.println(tm);
        System.out.println(MapUtility.sortOnValues(tm));
    }
}
