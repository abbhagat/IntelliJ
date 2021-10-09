package linkedlist;

import static linkedlist.LinkList.add;
import static linkedlist.TraverseList.traverseList;

public class DetectAndRemoveLoopInLinkedList {

    private static void detectAndRemoveLoop(Node first) {
        Node slow = first;
        Node fast = first.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                removeCycle(slow, first);
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
    }

    private static void removeCycle(Node slow, Node first) {
        for (Node curr = first; curr != null; curr = curr.next) {
            Node temp = slow;
            while (temp.next != slow && temp.next != curr) {
                temp = temp.next;
            }
            // If `temp` meets `curr`, then that means there is a loop, and `curr`
            // points to the first node of the loop and `temp` points to the last node
            if (temp.next == curr) {
                temp.next = null;
                return;
            }
        }
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
