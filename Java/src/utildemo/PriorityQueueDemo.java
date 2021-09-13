package utildemo;

import java.util.PriorityQueue;

public class PriorityQueueDemo {

    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(10, (i1, i2) -> i2 - i1);
        pq.offer(1);
        pq.offer(10);
        pq.offer(7);
        pq.offer(15);
        System.out.println(pq.size());
        System.out.println(pq);
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq);
    }
}
