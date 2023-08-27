package linkedlist;

import static linkedlist.LinkList.add;
import static linkedlist.TraverseList.traverseCyclicList;

public class SplitCircularLinkedListIntoTwoHalf {

    private static Node head1, head2;

    private static void splitList(Node head) {
        Node slow = head, fast = head.next, prev = null;
        while (fast != slow && fast.next != slow) {
            slow = slow.next;
            fast = fast.next.next;
            prev = slow;
        }
        if (fast == slow) {
            while (fast.next != slow) {
                fast = fast.next;
            }
        }
        head1 = head;
        head2 = prev.next;
        prev.next = head1;   // Making the first  list circular
        fast.next = head2;   // Making the second list circular
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        Node first = null;
        for (int x : a) {
            first = add(first, x);
        }
        first.next.next.next.next.next = first.next.next;
        splitList(first);
        traverseCyclicList(head1);
        System.out.println();
        traverseCyclicList(head2);
    }
}
