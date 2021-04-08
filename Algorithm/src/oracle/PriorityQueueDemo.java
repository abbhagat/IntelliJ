package oracle;

import java.util.Comparator;
import java.util.PriorityQueue;

class Compare implements Comparator<Integer> {

    public int compare(Integer i1, Integer i2) {
        return i2 - i1;
    }
}

public class PriorityQueueDemo {

    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(10, new Compare());
        pq.offer(1);
        pq.offer(10);
        pq.offer(7);
        System.out.println(pq.size());
        System.out.println(pq);
        System.out.println(pq.poll());
        System.out.println(pq);
        // }
    }
}
