package utildemo;

import java.util.*;

public class SetTraversal {

    private static final Object PRESENT = new Object();

    public static void main(String[] args) {
        Set<Integer> hs1 = new HashSet<>();
        Set<Integer> hs2 = new HashSet<>();
        Map<Integer, Object> map = new HashMap<>();
        hs1.add(1);
        hs1.add(2);
        hs1.add(3);
        hs1.add(4);
        hs1.add(5);
        hs2.add(3);
        hs2.add(2);
        hs2.add(5);
        hs2.add(10);
        hs2.add(15);
        hs2.add(21);
        //hs2.add(null);
        System.out.println(hs2);
        Iterator<Integer> itr;
        itr = hs2.iterator();
        while (itr.hasNext()) {
            map.put(itr.next(), PRESENT);
        }
        itr = hs2.iterator();
        while (itr.hasNext()) {
            int n = itr.next();
            System.out.println(n);
            if (!map.containsKey(n)) {
                System.out.println(n);
            }
        }
    }
}
