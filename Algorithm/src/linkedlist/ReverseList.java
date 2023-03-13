package linkedlist;

import static linkedlist.TraverseList.traverseList;

// Time Complexity:  O(n)
// Space Complexity: O(1)
public class ReverseList {

    private static Node reverse(Node first) {
        Node head = first, previous = null, temp;
        while (head != null) {
            temp = head;
            head = head.next;
            temp.next = previous;
            previous = first = temp;
        }
        return first;
    }

    public static Node reverseList(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node first = reverseList(node.next);
        node.next.next = node;
        node.next = null;
        return first;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        Node first = null;
        for (int x : a) {
            first = LinkList.add(first, x);
        }
        traverseList(first);
        first = reverseList(first);
        traverseList(first);
        first = reverse(first);
        traverseList(first);
    }
}
