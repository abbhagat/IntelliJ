package lld.arraylist;

import lombok.Getter;

@Getter
class ArrayList<E> {

  private E[] list;
  private int size;  // to keep track of the current size of the list

  public ArrayList() {
    this(10);
  }

  @SuppressWarnings("unchecked")
  public ArrayList(int size) {
    if (size <= 0) {
      throw new IllegalArgumentException("Invalid Size : " + size);
    }
    this.list = (E[]) new Object[size];
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
    int indexMoved = size - index - 1;
    if (indexMoved > 0) {
      System.arraycopy(list, index + 1, list, index, indexMoved);
    }
    list[--size] = null;
    return oldValue;
  }

  @SuppressWarnings("unchecked")
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
}
