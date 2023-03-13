package linkedlist;

import static linkedlist.LinkList.add;
import static linkedlist.MidPointOfLinkedList.findMid;
import static linkedlist.TraverseList.traverseList;

// Time complexity: O(n log n)

public class MergeSort {

    private static Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node mid = findMid(head);
        Node head2 = mid.next;
        mid.next = null;
        Node a = mergeSort(head);
        Node b = mergeSort(head2);
        return merge(a, b);
    }

    public static Node merge(Node a, Node b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        if (a.num < b.num) {
            a.next = merge(a.next, b);
            return a;
        }
        b.next = merge(a, b.next);
        return b;
    }

    public static void main(String[] args) {
        Node head = null;
        for (int x : new int[]{1, 3, 5, 2, 4}) {
            head = add(head, x);
        }
        traverseList(head);
        System.out.println();
        head = mergeSort(head);
        traverseList(head);
    }
}
