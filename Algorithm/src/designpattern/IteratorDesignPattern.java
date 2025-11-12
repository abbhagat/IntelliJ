package designpattern;

import java.util.Arrays;
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

    private final List<String> nameList = Arrays.asList("V705417", "W987622", "V987678", "Q123121");

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
