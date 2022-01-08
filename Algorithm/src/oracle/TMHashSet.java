package oracle;

import java.util.HashMap;
import java.util.Iterator;

public class TMHashSet<E> implements Cloneable, java.io.Serializable {

    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;
    private static final long serialVersionUID = 1L;

    TMHashSet() {
        map = new HashMap<>();
    }

    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }

    public boolean remove(E e) {
        return map.remove(e) == PRESENT;
    }

    public int size() {
        return map.size();
    }

    public boolean contains(E e) {
        return map.containsKey(e);
    }

    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    public void clear() {
        map.clear();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public Object clone() {
        try {
            TMHashSet<E> newSet = (TMHashSet<E>) super.clone();
            newSet.map = (HashMap<E, Object>) map.clone();
            return newSet;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }

    public static void main(String[] args) {
        TMHashSet<Integer> set = new TMHashSet<>();
        set.add(1);
        set.add(1);
        set.add(2);
        set.add(3);
        Iterator<Integer> itr = set.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println(set.contains(2));
        set.clear();
        System.out.println(set.isEmpty());
    }
}
