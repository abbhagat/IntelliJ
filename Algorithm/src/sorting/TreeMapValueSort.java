package sorting;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class MapUtility {
    public static <K, V extends Comparable<V>> Map<K, V> sortByValues(Map<K, V> map) {
        Map<K, V> sortedMap = new TreeMap<>(new ValueComparator<>(map));
        sortedMap.putAll(map);
        return sortedMap;
    }

    public static <K extends Comparable<K>, V> Map<K, V> sortByKeys(Map<K, V> map) {
        Map<K, V> sortedMap = new TreeMap<>(Comparator.reverseOrder());
        sortedMap.putAll(map);
        return sortedMap;
    }
}

class ValueComparator<K, V extends Comparable<V>> implements Comparator<K> {

    private final Map<K, V> map;

    public ValueComparator(Map<K, V> map) {
        this.map = map;
    }

    public int compare(K k1, K k2) {
        V v1 = map.get(k1);
        V v2 = map.get(k2);
        return v2.compareTo(v1);
    }
}

public class TreeMapValueSort {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("Z", 2);
        map.put("C", 3);
        System.out.println(map);
        map = MapUtility.sortByKeys(map);
        System.out.println(map);
        System.out.println(MapUtility.sortByValues(map));
    }
}
