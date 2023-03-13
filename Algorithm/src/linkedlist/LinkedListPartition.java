package linkedlist;

import static linkedlist.LinkList.add;
import static linkedlist.TraverseList.traverseList;

public class LinkedListPartition {

    private static Node partition(Node head, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        Node temp1 = new Node(-1, head);
        Node temp2 = new Node(-1, head);
        Node curr = head, p = temp1, q = temp2;
        while (curr != null) {
            if (curr.num < n) {
                p.next = curr;
                p = p.next;
            } else {
                q.next = curr;
                q = q.next;
            }
            curr = curr.next;
        }
        q.next = null;
        p.next = temp2.next;
        return temp1.next;
    }

    public static void main(String[] args) {
        Node first = null;
        for (int x : new int[]{1, 4, 3, 2, 5, 2}) {
            first = add(first, x);
        }
        traverseList(first);
        first = partition(first, 3);
        traverseList(first);
    }
}
