package linkedlist;

import static linkedlist.TraverseList.traverseList;

public class ReverseList {

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
    }
}
