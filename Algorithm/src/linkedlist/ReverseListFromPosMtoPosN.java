package linkedlist;

import static linkedlist.LinkList.add;
import static linkedlist.TraverseList.traverseList;

// Time Complexity:  O(n)
// Space Complexity: O(1)
public class ReverseListFromPosMtoPosN {

    private static Node reverseListFromPosMtoPosN(Node first, int m, int n) {
        if (m >= n || first == null) {
            return first;
        }
        Node head  = new Node(-1, first);
        Node prev  = head;
        for (int i = 1; i < m; i++) {
             prev  = prev.next;
        }
        Node temp  = prev.next;
        for (int i = m; i < n; i++) {
            Node next = temp.next.next;
            temp.next.next = prev.next;
            prev.next = temp.next;
            temp.next = next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        Node first = null;
        for (int x : new int[]{1, 2, 3, 4, 5, 6, 7, 8}) {
            first = add(first, x);
        }
        traverseList(first);
        first = reverseListFromPosMtoPosN(first, 3, 5);
        traverseList(first);
    }
}
