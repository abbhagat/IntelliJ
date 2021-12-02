package linkedlist;

import static linkedlist.LinkList.add;
import static linkedlist.TraverseList.traverseList;

// Time Complexity : O(1)
// Auxilliary Space : O(1)

public class DeleteNodeWithoutHeadPointer {

    private static void deleteNode(Node node) {
        if (node == null || node.next == null) {
            return;
        }
        node.num = node.next.num;
        Node temp = node.next;
        node.next = node.next.next;
        temp = null;
    }

    public static void main(String[] args) {
        Node first = null;
        for (int x : new int[]{1, 2, 3, 4, 5}) {
            first = add(first, x);
        }
        traverseList(first);
        System.out.println();
        deleteNode(first.next.next);
        traverseList(first);
    }
}
