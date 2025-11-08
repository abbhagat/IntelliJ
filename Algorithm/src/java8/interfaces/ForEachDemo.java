package java8.interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ForEachDemo {

    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(1, 2, 3, 4, 5);
        myList.forEach(System.out::println);

        // traversing through forEach method of Iterable with anonymous class
        myList.forEach(new Consumer<Integer>() {
            public void accept(Integer i) {
                System.out.println("forEach anonymous class Value::" + i);
            }
        });
        // traversing with Consumer interface implementation
        myList.forEach(new MyConsumer());
//        myList.forEach(MyConsumer::accept);
    }
}

// Consumer implementation that can be reused
class MyConsumer implements Consumer<Integer> {
    public void accept(Integer i) {
        System.out.println("Consumer impl Value::" + i);
    }
}
