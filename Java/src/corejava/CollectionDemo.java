package corejava;

import java.util.*;

public class CollectionDemo {
    public static void main(String[] args) {
        List<Integer> al = new ArrayList<>(1);
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);
        Iterator<Integer> itr = al.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
            itr.remove();
        }
        System.out.println();
        System.out.println(al);
        ListIterator<Integer> litr = al.listIterator(al.size());
        litr.add(6);
        while (litr.hasPrevious()) {
            System.out.println(litr.previous());
            litr.remove();
        }
        System.out.println(al);
        // al = (ArrayList<Integer>)Collections.unmodifiableList(al);
        //TreeMap<String,Integer> hm = new TreeMap<String,Integer>();
        Map<String, Integer> hm = new HashMap<>();
        hm.put("A", 65);
        hm.put("C", null);
        hm.put("", 30);
        hm.put("B", null);
        hm.put(null, null);
        hm.put(null, null);
        hm.put(null, null);
        Set<Map.Entry<String, Integer>> set = hm.entrySet();
        for (Map.Entry<String, Integer> map : set) {
            System.out.println("Key :" + map.getKey() + "  Value : " + map.getValue());
        }
    }
}
