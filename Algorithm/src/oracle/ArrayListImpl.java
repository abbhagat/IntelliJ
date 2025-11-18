package oracle;

import lombok.Getter;

@Getter
public class ArrayListImpl<E> {

  private E[] list;
  private int size;

  public ArrayListImpl() {
    this(10);
  }

  public ArrayListImpl(int initialCapacity) {
    if (initialCapacity <= 0) {
      throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
    }
    this.list = (E[]) new Object[initialCapacity];
  }

  public boolean add(E e) {
    validateCapacity(size + 1);
    list[size++] = e;
    return true;
  }

  public E get(int index) {
    validateIndex(index);
    return list[index];
  }

  public E remove(int index) {
    validateIndex(index);
    E oldValue = list[index];
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

  private void validateIndex(int index) {
    if (index < 0 || index >= size) {
      throw new ArrayIndexOutOfBoundsException("Invalid index :" + index);
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
    for (int i = 0; i < al.getSize(); i++) {
      System.out.println(al.get(i));
    }
    al.remove(2);
    System.out.println("Changed List");
    for (int i = 0; i < al.getSize(); i++) {
      System.out.println(al.get(i));
    }
    System.out.println();
    Object[] obj = al.getList();
    for (Object o : obj) {
      System.out.println(o);
    }
  }
}
