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
        Node curr = mid.next;
        mid.next = null;
        while (curr != null) {         // swap(cur,mid.next);
            Node temp = curr.next;
            curr.next = mid.next;
            mid.next = curr;
            curr = temp;
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
