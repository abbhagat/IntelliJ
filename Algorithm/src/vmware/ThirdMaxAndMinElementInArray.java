package vmware;

import java.util.PriorityQueue;

// Time  Complexity : O(n)
// Space Complexity : O(1)
public class ThirdMaxAndMinElementInArray {

    private static int findThirdMax(int[] a) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : a) {
            pq.add(x);
            if (pq.size() > 3) {
                pq.poll();
            }
        }
        return pq.isEmpty() ? -1 : pq.peek();
    }

    private static int findThirdMin(int[] a) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y) -> y - x);
        for (int x : a) {
            pq.add(x);
            if (pq.size() > 3) {
                pq.poll();
            }
        }
        return pq.isEmpty() ? -1 : pq.peek();
    }

    public static void main(String[] args) {
        System.out.println(findThirdMax(new int[]{1, 2, 3, 4, 5}));
        System.out.println(findThirdMax(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        System.out.println(findThirdMin(new int[]{6, 7, 8, 9, 10}));
        System.out.println(findThirdMin(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }
}
