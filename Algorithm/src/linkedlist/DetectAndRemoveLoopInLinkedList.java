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
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        if (slow == fast) {
            slow = first;
            if (slow != fast) {
                while (slow.next != fast.next) {
                    slow = slow.next;
                    fast = fast.next;
                }
                fast.next = null;               // since fast->next is the looping point remove loop
            } else {
                while (fast.next != slow) {   // This case is added if fast and slow pointer meet at first position.
                    fast = fast.next;
                }
                fast.next = null;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 4, 3};
        Node first = null;
        for (int x : a) {
            first = add(first, x);
        }
        LinkList.last.next = first;
        detectAndRemoveLoop(first);
        traverseList(first);
    }
}
