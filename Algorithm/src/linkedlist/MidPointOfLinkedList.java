package linkedlist;

import static linkedlist.LinkList.add;

public class MidPointOfLinkedList {

    public static Node findMid(Node first) {
        Node slow = first, fast = first.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node findPrevMidPoint(Node first) {
        if (first == null || first.next == null) {
            return first;
        }
        Node slow = first, prev_slow = first, fast = first.next;
        while (fast != null && fast.next != null) {
            prev_slow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return prev_slow;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        Node first = null;
        for (int x : a) {
            first = add(first, x);
        }
        System.out.println(findMid(first).num);
    }
}
