package linkedlist;

import static linkedlist.LinkList.add;
import static linkedlist.TraverseList.traverseList;

// Given a LinkedList Partition, all the nodes in such a way
// that all node less than x comes before x and remaining after it.

public class LinkedListPartition {

    private static Node partition(Node head, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        Node temp1 = new Node(-1, head);
        Node temp2 = new Node(-1, head);
        Node p = temp1, q = temp2;
        for (Node temp = head; temp != null; temp = temp.next) {
            if (temp.num < n) {
                p.next = temp;
                p = p.next;
            } else {
                q.next = temp;
                q = q.next;
            }
        }
        q.next = null;
        p.next = temp2.next;
        return temp1.next;
    }

    public static void main(String[] args) {
        Node first = null;
        for (int x : new int[]{1, 3, 6, 2, 5, 4, 0}) {
            first = add(first, x);
        }
        traverseList(first);
        first = partition(first, 3);
        traverseList(first);
    }
}
