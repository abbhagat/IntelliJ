package linkedlist;

import static linkedlist.LinkList.add;
import static linkedlist.TraverseList.traverseList;

public class DetectAndRemoveLoopInLinkedList {

    private static void detectAndRemoveLoop(Node first) {
        if (first == null || first.next == null) {
            return;
        }
        Node slow = first.next;
        Node fast = first.next.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                removeCycle(fast, first);
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
    }

    private static void removeCycle(Node fast, Node first) {
        Node slow = first;
        if (slow != fast) {
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
        } else {
            while (fast.next != slow) {  // This case is added if fast and slow pointer meet at first position.
                fast = fast.next;
            }
        }
        fast.next = null;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        Node first = null;
        for (int x : a) {
            first = add(first, x);
        }
        first.next.next.next.next.next = first.next.next;
        detectAndRemoveLoop(first);
        traverseList(first);
    }
}
