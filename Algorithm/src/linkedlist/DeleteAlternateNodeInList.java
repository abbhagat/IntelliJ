package linkedlist;

import static linkedlist.LinkList.add;
import static linkedlist.TraverseList.traverseList;

// Time complexity: O(n)
public class DeleteAlternateNodeInList {

    private static void deleteAlternateNode(Node head) {
        for (Node temp = head; temp != null && temp.next != null; temp = temp.next) {
            temp.next = temp.next.next;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        Node first = null;
        for (int x : a) {
            first = add(first, x);
        }
        traverseList(first);
        deleteAlternateNode(first);
        traverseList(first);
    }
}
