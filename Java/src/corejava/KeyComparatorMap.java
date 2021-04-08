package corejava;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class KeyComparator implements Comparator<String> {

    public int compare(String s1, String s2) {
        return s2.compareTo(s1);
    }
}

public class KeyComparatorMap {
    public static void main(String[] args) {
    	//Comparator<String> c = (s1, s2) -> s1.compareTo(s2);
    	//TreeMap<String, String> tm = new TreeMap<>(c);
    	//TreeMap<String, String> tm = new TreeMap<>(reverseOrder());
        TreeMap<String, String> tm = new TreeMap<String, String>(new KeyComparator());
        tm.put("1", "Z");
        tm.put("2", "C");
        tm.put("7", "E");
        tm.put("4", "A");
        tm.put("6", "B");
        tm.put("5", "N");
        tm.put("3", "P");
        System.out.println("Sorted Map: " + tm);
        Set<Map.Entry<String, String>> set = tm.entrySet();
        for (Map.Entry<String, String> map : set) {
            System.out.println("Key :" + map.getKey() + "\tValue :" + map.getValue());
        }
    }
}
