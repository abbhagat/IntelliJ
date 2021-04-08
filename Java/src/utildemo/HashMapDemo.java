package utildemo;

import java.util.*;

public class HashMapDemo {

    public int hashCode() {
        return 1;
    }

    public static void main(String[] args) {
        LinkedHashMap map;
        Map<String, Integer> hm = new HashMap<>();
        System.out.println(hm.put("ABC", 65));
        System.out.println(hm.put("A", 60));
        System.out.println(hm.put("B", 66));
        System.out.println(hm.put(null, 66));
        System.out.println(hm.put(null, 67));
        System.out.println(hm.remove("B"));
        Set s = hm.keySet();
        Collection<Integer> se = hm.values();
        System.out.println(s);
        Map synchronizedMap = Collections.synchronizedMap(hm);
        hm.keySet();
        hm.values();
        Set<Map.Entry<String, Integer>> set = synchronizedMap.entrySet();
        for (Map.Entry<String, Integer> m : set) {
            System.out.println(m.getKey() + "\t" + m.getValue());

        }
        Iterator<Map.Entry<String, Integer>> itr = hm.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<String, Integer> m = itr.next();
            System.out.println(m.getKey() + "\t" + m.getValue());
        }
        synchronizedMap.forEach((k,v)->{
            System.out.println(k + "\t" + v);
        });
    }
}
