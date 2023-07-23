package linkedlist;

import static linkedlist.LinkList.add;
import static linkedlist.TraverseList.traverseList;

public class DetectAndRemoveLoopInLinkedList {
    private static void detectAndRemoveLoop(Node first) {
        if (first == null || first.next == null) {
            return;
        }
        Node slow = first, fast = first.next;
        while (fast != slow && fast.next != slow) {
            slow = slow.next;
            fast = fast.next.next;
        }
        removeCycle(slow, fast);
    }

    private static void removeCycle(Node slow, Node fast) {
        if (fast == slow) {
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
        first.next.next.next = first.next;
        detectAndRemoveLoop(first);
        traverseList(first);
    }
}
