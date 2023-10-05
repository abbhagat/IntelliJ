package vmware;

import java.util.PriorityQueue;

// Time  Complexity O(n)
// Space Complexity O(1)
public class ThirdMaxElementInArray {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : a) {
            pq.add(x);
            if (pq.size() > 3) {
                pq.poll();
            }
        }
        System.out.println(pq.peek());
    }
}
