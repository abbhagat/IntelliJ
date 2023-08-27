package linkedlist;

import static linkedlist.LinkList.add;
import static linkedlist.TraverseList.traverseList;

public class InsertNodeInSortedLinkedList {

    public static Node insertNodeInSortedLinkedList(Node first, int num) {
        if (null == first || num < first.num) {
            return new Node(num, first);
        } else {
            Node prev = null;
            for (Node temp = first; temp != null && temp.num < num; temp = temp.next) {
                prev = temp;
            }
            Node node = new Node(num, null);
            node.next = prev.next;
            prev.next = node;
            return first;
        }
    }

    public static void main(String[] args) {
        Node first = null;
        for (int x : new int[]{1, 3, 5, 8}) {
            first = add(first, x);
        }
        first = insertNodeInSortedLinkedList(first, 0);
        first = insertNodeInSortedLinkedList(first, 2);
        first = insertNodeInSortedLinkedList(first, 4);
        first = insertNodeInSortedLinkedList(first, 7);
        first = insertNodeInSortedLinkedList(first, 9);
        traverseList(first);
    }
}
