package oracle;

import java.io.Serializable;
import java.util.RandomAccess;

public class ArrayListImpl<T> implements RandomAccess, Cloneable, Serializable {

    private static final long serialVersionUID = 1L;

    private transient Object[] list;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public Object[] getList() {
        return list;
    }

    public int size() {
        return size;
    }

    public ArrayListImpl() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayListImpl(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        this.list = new Object[initialCapacity];
    }

    public boolean add(T obj) {
        validateCapacity(size + 1);
        list[size++] = obj;
        return true;
    }

    public Object get(int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Invalid index :" + index);
        }
        return list[index];
    }

    public Object remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Object oldValue = list[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(list, index + 1, list, index, numMoved);
        }
        list[--size] = null; // Let gc do its work
        return oldValue;
    }

    private void validateCapacity(int minCapacity) {
        int oldCapacity = list.length;
        if (minCapacity > oldCapacity) {
            Object oldData[] = list;
            int newCapacity = oldCapacity * 3 / 2 + 1; //Size increases by 1.5 times.
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            list = new Object[newCapacity];
            System.arraycopy(oldData, 0, list, 0, size);
        }
    }

    public static void main(String[] args) {
        ArrayListImpl<Integer> al = new ArrayListImpl();
        al.add(1);
        al.add(2);
        al.add(3);
        for (int i = 0; i < al.size(); i++) {
            System.out.println(al.list[i]);
        }
        al.remove(2);
        System.out.println("Changed List");
        for (int i = 0; i < al.size(); i++) {
            System.out.println(al.list[i]);
        }
    }
}
