package sorting;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElement {

    private static int findKthSmallest(int[] a, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int x : a) {
            pq.add(x);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return !pq.isEmpty() ? pq.peek() : -1;
    }

    public static void main(String[] args) {
        System.out.println(findKthSmallest(new int[]{1, 3, 5, 2, 4}, 2));
        System.out.println(findKthSmallest(new int[]{1, 3, 5, 2, 4}, 3));
    }
}
