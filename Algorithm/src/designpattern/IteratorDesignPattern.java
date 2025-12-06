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

class NameRepository implements Iterable<String> {

  private final List<String> nameList = List.of("A", "B ", "C", "D", "E");

  @Override
  public Iterator<String> iterator() {
    return new NameIterator();
  }

  private class NameIterator implements Iterator<String> {

    private int index = 0;

    @Override
    public boolean hasNext() {
      return index < nameList.size();
    }

    @Override
    public String next() {
      return nameList.get(index++);
    }

    @Override
    public String curr() {
      return nameList.get(index);
    }
  }
}

public class IteratorDesignPattern {

  public static void main(String[] args) {
    NameRepository nameRepository = new NameRepository();
    Iterator<String> iterator = nameRepository.iterator();
    System.out.println(iterator.curr());
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}
