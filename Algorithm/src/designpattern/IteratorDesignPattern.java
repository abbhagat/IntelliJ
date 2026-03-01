package designpattern;

import java.util.List;

interface Iterable<E> {
  Iterator<E> iterator();
}

interface Iterator<E> {
  boolean hasNext();
  E curr();
  E next();
}

class NameRepository<E> implements Iterable<E> {

  private final List<E> list;

  public NameRepository(List<E> list) {
    this.list = list;
  }

  @Override
  public Iterator<E> iterator() {
    return new NameIterator();
  }

  private class NameIterator implements Iterator<E> {

    private int index = 0;

    @Override
    public boolean hasNext() {
      return index < list.size();
    }

    @Override
    public E next() {
      return list.get(index++);
    }

    @Override
    public E curr() {
      return list.get(index);
    }
  }
}

public class IteratorDesignPattern {

  public static void main(String[] args) {
    Iterable<String> nameRepository = new NameRepository<>(List.of("A", "B ", "C", "D", "E"));
    Iterator<String> iterator = nameRepository.iterator();
    System.out.println(iterator.curr());
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}
