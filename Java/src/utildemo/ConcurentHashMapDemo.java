package utildemo;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurentHashMapDemo {
    public static void main(String[] args) {
        Map<String, String> chm = new ConcurrentHashMap<>();
        //Map<String, String> chm = new HashMap<>();
        chm.put("A", "65");
        chm.put("A", "66");
        System.out.println(chm.get("AA"));
        // chm.clear();
        System.out.println(chm.size());

        Set<Map.Entry<String, String>> set = chm.entrySet();
        for (Map.Entry<String, String> map : set) {
            System.out.println("Key :" + map.getKey() + "\tValue :" + map.getValue());
            chm.put("B", "66");
        }

        Iterator<Map.Entry<String, String>> iterator = chm.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> map = iterator.next();
            chm.put("C", "67");
            System.out.println(map.getKey() + "\t" + map.getValue());
        }
        System.out.println(chm);
    }
}
