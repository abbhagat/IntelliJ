package linkedlist;

import static linkedlist.LinkList.add;
import static linkedlist.MidPointOfLinkedList.findMid;
import static linkedlist.TraverseList.traverseList;

public class ReorderLinkList {

    private static void reorderList(Node head) {
        if (head == null || head.next == null) {
            return;
        }
        Node mid = findMid(head);
        Node cur = mid.next;
        mid.next = null;
        while (cur != null) {
            // swap(cur.next,mid.next);
            Node temp = cur.next;
            cur.next = mid.next;
            mid.next = cur;
            cur = temp;
        }
        Node left = head, right = mid.next;
        while (left != null && mid != null && right != null) {
            mid.next   = right.next;
            right.next = left.next;
            left.next  = right;
            left       = right.next;
            right      = mid.next;
        }
    }

    public static void main(String[] args) {
        Node first = null;
        for (int x : new int[]{1, 2, 3, 4, 5}) {
            first = add(first, x);
        }
        traverseList(first);
        System.out.println();
        reorderList(first);
        traverseList(first);
    }
}
