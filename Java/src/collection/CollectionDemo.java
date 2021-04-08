package collection;

import java.util.*;

public class CollectionDemo {
    public static void main(String[] args) {
        List<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);
        System.out.println(al);
        Collection c1 = Collections.unmodifiableCollection(al);
        Collection c2 = Collections.synchronizedCollection(al);
        al.remove(new Integer(7));  /** as ArrayList do not have 7 no change in the list */
        //c1.remove(new Integer(3)); // java.lang.UnsupportedOperationException
        System.out.println(c1);
        System.out.println(c2);
        Iterator<Integer> itr = c1.iterator();
        synchronized (c2) {
            Iterator<Integer> itr2 = al.iterator();
            while (itr.hasNext()) {
                // al.remove(new Integer(1)); // ConcurrentModificationException
                // itr.remove();    // java.lang.UnsupportedOperationException
                System.out.println(itr.next());
            }
        }
        System.out.println("List Iterator");
        ListIterator<Integer> ltr = al.listIterator(3);
        while (ltr.hasPrevious()) {
            System.out.println(ltr.previous());
        }
    }
}
