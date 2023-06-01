package linkedlist;

import static linkedlist.LinkList.add;
import static linkedlist.TraverseList.traverseList;

// Time Complexity  : O(1)
// Auxiliary Space  : O(1)

public class DeleteNodeWithoutHeadPointer {

    private static void deleteNode(Node node) {
        if (node == null || node.next == null) {
            return;
        }
        node.num = node.next.num;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        Node first = null;
        for (int x : new int[]{1, 2, 3, 4, 5}) {
            first = add(first, x);
        }
        traverseList(first);
        deleteNode(first.next.next);  // delete 3 from the list
        traverseList(first);
    }
}
