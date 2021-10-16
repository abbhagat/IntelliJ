package sorting;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElement {

    public static void main(String[] args) {
        int[] a = {3, 8, 1, 9, 4, 2, 6, 7, 10, 5};
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int kth = 4;
        for (int x : a) {
            pq.add(x);
            if (pq.size() > kth) {
                pq.poll();
            }
        }
        System.out.println(pq.peek());
    }
}