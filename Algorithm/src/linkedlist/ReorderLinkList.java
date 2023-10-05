package linkedlist;

import static linkedlist.LinkList.add;
import static linkedlist.MidPointOfLinkedList.findMid;
import static linkedlist.TraverseList.traverseList;
// Given List -> l0->l1->l2->....ln-1->ln
// O/P :-> l0->ln->l1->ln-1->l2->ln-2

public class ReorderLinkList {

    private static void reorderList(Node head) {
        if (head == null || head.next == null) {
            return;
        }
        Node mid = findMid(head);
        Node head2 = mid.next;
        mid.next = null;
        while (head2 != null) {
            Node next = head2.next;
            head2.next = mid.next;
            mid.next = head2;
            head2 = next;
        }
        Node left = head, right = mid.next;
        while (left != null && right != null) {
            mid.next   = right.next;
            right.next = left.next;
            left.next  = right;
            left       = right.next;
            right      = mid.next;
        }
    }

    public static void main(String[] args) {
        Node first = null;
        for (int x : new int[]{1, 2, 3, 4}) {
            first = add(first, x);
        }
        traverseList(first);
        reorderList(first);
        traverseList(first);
    }
}
