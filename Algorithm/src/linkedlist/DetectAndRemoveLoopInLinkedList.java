package linkedlist;

import static linkedlist.LinkList.add;
import static linkedlist.TraverseList.traverseList;

public class DetectAndRemoveLoopInLinkedList {
    private static void detectAndRemoveLoop(Node first) {
        Node slow = first, fast = first.next;
        boolean hasCycle;
        while (true) {
            if (fast == null || fast.next == null) {
                hasCycle = false;
                break;
            }
            if (fast == slow || fast.next == slow) {
                hasCycle = true;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        if (hasCycle) {
            removeCycle(slow, fast);
        }
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
        first.next.next.next.next = first.next.next;
        detectAndRemoveLoop(first);
        traverseList(first);
    }
}
