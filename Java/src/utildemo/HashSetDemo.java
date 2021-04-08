package utildemo;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static utildemo.SetUtility.sortSet;

class SetUtility {
    public static <K extends Comparable<K>> Set sortSet(Set<K> set) {
        Set<K> sortedSet = new TreeSet<>(Comparator.reverseOrder());
        sortedSet.addAll(set);
        return sortedSet;
    }
}

public class HashSetDemo {
    public static void main(String[] args) {
        Set<String> hs = new HashSet<>();
        hs.add("A");
        hs.add("C");
        hs.add("X");
        hs.add("E");
        hs.add("T");
        //hs.add(null);  // null we be added to the HashSet
        System.out.println(hs);
        //Set<String> sortedSet = new TreeSet<>((k1, k2) -> k2.compareTo(k1));
        Set<String> sortedSet = sortSet(hs);
        sortedSet.addAll(hs);
        System.out.println(sortedSet);
    }
}
