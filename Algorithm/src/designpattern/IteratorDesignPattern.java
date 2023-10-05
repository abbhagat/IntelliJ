package designpattern;

import java.util.Arrays;
import java.util.List;

interface Iterator {
    boolean hasNext();

    Object next();
}

interface Iterable {
    Iterator iterator();
}

class NameRepository implements Iterable {

    private final List<String> names = Arrays.asList("V705417", "W987622", "V987678", "Q123121");

    @Override
    public Iterator iterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < names.size();
        }

        @Override
        public Object next() {
            return names.get(index++);
        }
    }
}

public class IteratorDesignPattern {
    public static void main(String[] args) {
        NameRepository nameRepository = new NameRepository();
        Iterator iterator = nameRepository.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
