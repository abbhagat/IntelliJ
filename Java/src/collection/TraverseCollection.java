package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TraverseCollection {

    public static void main(String[] args) {
        List<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);
        al.add(6);
        al.add(3);
        al.add(7);
        System.out.println(al);
        System.out.println(al.remove(new Integer(3))); // removes the first occurance of 3 from ArrayList
        System.out.println(al);
        Iterator<Integer> itr = al.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
            /**
             *  itr.remove();  // no concurrent modification exception and the ArrayList will be empty after loop completes
             *  al.remove(3); // Concurrent Modification Exception
             *  al.add(7);   // Concurrent Modification Exception
             */
        }
        System.out.println(al);
        for (int x : al) {
            System.out.println(x + " ");
            al.remove(3); // Concurrent Modification Exception
        }
    }

}
