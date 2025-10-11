package linkedlist;

import static linkedlist.MidPointOfLinkedList.findMid;
import static linkedlist.ReverseList.reverseList;
import static linkedlist.TraverseList.traverseList;

public class ReverseHalfLinkedList {


    private static Node reverseHalfList(Node head) {
        Node mid = findMid(head);
        Node midNext = mid.next;
        mid.next = null;
        Node node = reverseList(head);  // node.num = 3
        head.next = midNext;
        return node;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        Node first = null;
        for (int x : a) {
            first = LinkList.add(first, x);
        }
        traverseList(first);
        Node node = reverseHalfList(first);
        traverseList(node);
    }
}
