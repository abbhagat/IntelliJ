package linkedlist;

import static linkedlist.LinkList.add;
import static linkedlist.TraverseList.traverseList;

public class DetectAndRemoveLoopInLinkedList {

    private static void detectAndRemoveLoop(Node first) {
        Node slow = first;
        Node fast = first.next;
        while (true) {
            if (fast == null || fast.next == null) {
                return;
            }
            if (fast == slow || fast.next == slow) {
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        if (slow == fast) {
            while (fast.next != slow) {
                fast = fast.next;
            }
        }
        fast.next = null;
    }

    private static void removeCycle(Node slow, Node fast) {
        if (slow == fast) {
            while (fast.next != slow) {
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
