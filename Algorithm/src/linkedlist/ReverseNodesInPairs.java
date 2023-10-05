package linkedlist;

import static linkedlist.TraverseList.traverseList;

// Time Complexity : O(n)
// Space Complexity: O(1)
public class ReverseNodesInPairs {

    private static Node reverseNodesInPairs(Node first) {
        Node head = new Node(-1, first);
        Node temp = head;
        while (temp != null && temp.next != null && temp.next.next != null) {
            temp.next = swap(temp.next, temp.next.next);
            temp = temp.next.next;
        }
        return head.next;
    }

    private static Node swap(Node a, Node b) {
        a.next = b.next;
        b.next = a;
        return b;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        Node first = null;
        for (int x : a) {
            first = LinkList.add(first, x);
        }
        traverseList(first);
        first = reverseNodesInPairs(first);
        traverseList(first);
    }
}
