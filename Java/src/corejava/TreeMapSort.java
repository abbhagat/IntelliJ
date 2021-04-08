package corejava;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class MapUtility {

    public static <K extends Comparable<K>, V extends Comparable<V>> Map<K, V> sortOnValues(Map<K, V> unsortedMap) {
        Map<K, V> sortedMap = new TreeMap<>(new MapValueComparator<>(unsortedMap));
        sortedMap.putAll(unsortedMap);
        return sortedMap;
    }

    public static <K extends Comparable<K>, V extends Comparable<V>> Map<K, V> sortOnKeys(Map<K, V> unsortedMap) {
        Map<K, V> sortedMap = new TreeMap<>(new MapKeyComparator<>(unsortedMap));
        sortedMap.putAll(unsortedMap);
        return sortedMap;
    }
}

class MapValueComparator<K extends Comparable<K>, V extends Comparable<V>> implements Comparator<K> {

    Map<K, V> map;

    MapValueComparator(Map<K, V> map) {
        this.map = map;
    }

    public int compare(K key1, K key2) {
        V value1 = map.get(key1);
        V value2 = map.get(key2);

        // return value1.compareTo(value2); //Sort in ascending order
        return value2.compareTo(value1); // Sort in descending order
    }
}

class MapKeyComparator<K extends Comparable<K>, V extends Comparable<V>> implements Comparator<K> {

    Map<K, V> map;

    MapKeyComparator(Map<K, V> map) {
        this.map = map;
    }

    public int compare(K key1, K key2) {

        return key1.compareTo(key2); // Sort in ascending order
        // return key2.compareTo(key1); // Sort in descending order
    }
}

public class TreeMapSort {
    public static void main(String[] args) {
        Map<String, String> unsortedMap = new HashMap<String, String>();
        unsortedMap.put("1", "Z");
        unsortedMap.put("2", "C");
        unsortedMap.put("7", "E");
        unsortedMap.put("4", "A");
        unsortedMap.put("6", "B");
        unsortedMap.put("5", "N");
        unsortedMap.put("3", "P");

        System.out.println("Unsorted Map: " + unsortedMap);
        unsortedMap = MapUtility.sortOnKeys(unsortedMap);
        System.out.println("Sort Map Keys: " + unsortedMap);
        unsortedMap = MapUtility.sortOnValues(unsortedMap);
        System.out.println("Sort Map Values: " + unsortedMap);
    }
}
