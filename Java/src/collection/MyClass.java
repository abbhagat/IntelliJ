package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

interface I {
    public static final int x = 5;
}

public class MyClass implements I {
    int x = 10;

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        I i = myClass;
        // myClass = i;
        System.out.println(i.x);
        List<Integer> al = new ArrayList<>();
        for (int j = 0; j < 5; j++) {
            al.add(j);
        }
        int count = 0;
        System.out.println(al);
        for (int y : al) {
            System.out.println(y);
            if (count == 2) {
                //al.remove(count); // ConcurrentModificationException thrown here
            } else {
                count++;
            }
            // System.out.println(y);
        }
        System.out.println(al);
        Iterator<Integer> itr = al.iterator();
        while (itr.hasNext()) {
            int x = itr.next();
            if (x == 2) {
                al.remove(x); // ConcurrentModificationException thrown here
            }
        }
        System.out.println(al);
    }
}
