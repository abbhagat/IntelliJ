package oracle;

public class ArrayListImpl<E> {

  private transient E[] list;
  private int size;
  private static final int DEFAULT_CAPACITY = 5;

  public ArrayListImpl() {
    this(DEFAULT_CAPACITY);
  }

  public ArrayListImpl(int initialCapacity) {
    if (initialCapacity <= 0) {
      throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
    }
    this.list = (E[]) new Object[initialCapacity];
  }

  public E[] getList() {
    return list;
  }

  public int size() {
    return size;
  }

  public boolean add(E e) {
    validateCapacity(size + 1);
    list[size++] = e;
    return true;
  }

  public E get(int index) {
    if (index < 0 || index >= size) {
      throw new ArrayIndexOutOfBoundsException("Invalid index :" + index);
    }
    return list[index];
  }

  public E remove(int index) {
    if (index < 0 || index >= size) {
      throw new ArrayIndexOutOfBoundsException("Invalid index :" + index);
    }
    E oldValue   = list[index];
    int numMoved = size - index - 1;
    if (numMoved > 0) {
      System.arraycopy(list, index + 1, list, index, numMoved);
    }
    list[--size] = null;
    return oldValue;
  }

  private void validateCapacity(int minCapacity) {
    int oldCapacity = list.length;
    if (minCapacity > oldCapacity) {
      E[] oldData = list;
      int newCapacity = oldCapacity * 3 / 2 + 1;
      list = (E[]) new Object[newCapacity];
      System.arraycopy(oldData, 0, list, 0, size);
    }
  }

  public static void main(String[] args) {
    ArrayListImpl<Integer> al = new ArrayListImpl<>();
    al.add(1);
    al.add(2);
    al.add(3);
    al.add(4);
    al.add(5);
    al.add(6);
    al.add(7);
    for (int i = 0; i < al.size(); i++) {
      System.out.println(al.get(i));
    }
    al.remove(2);
    System.out.println("Changed List");
    for (int i = 0; i < al.size(); i++) {
      System.out.println(al.get(i));
    }
  }
}
