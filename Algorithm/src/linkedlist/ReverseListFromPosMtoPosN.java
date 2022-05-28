package linkedlist;

import static linkedlist.LinkList.add;
import static linkedlist.TraverseList.traverseList;

public class ReverseListFromPosMtoPosN {

    private static Node reverseList(Node head, int m, int n) {
        if (m >= n || head == null) {
            return head;
        }
        Node first = new Node(0, head);
        Node prev = first;
        for (int i = 1; i < m; i++) {
            prev = prev.next;
        }
        Node t = prev.next;
        for (int i = m; i < n; i++) {
            Node temp = t.next.next;
            t.next.next = prev.next;
            prev.next = t.next;
            t.next = temp;
        }
        return first.next;
    }

    public static void main(String[] args) {
        Node first = null;
        for (int x : new int[]{1, 2, 3, 4, 5}) {
            first = add(first, x);
        }
        traverseList(first);
        System.out.println();
        first = reverseList(first, 2, 4);
        traverseList(first);
    }
}
