package doublylinkedlist;

import static doublylinkedlist.CreateList.createList;
import static doublylinkedlist.TraverseList.traverseList;

// Time Complexity: O(N), where N denotes the number of nodes in the doubly linked list.
// Auxiliary Space: O(1)
public class ReverseList {

    private static Node reverseList(Node head) {
        Node temp = null;
        Node current = head;
        // swap next and prev for all nodes of doubly linked list
        while (current != null) {
            temp = current.left;
            current.left = current.right;
            current.right = temp;
            current = current.left;
        }
        /* Before changing head, check for the cases like
         empty list and list with only one node */
        if (temp != null) {
            head = temp.left;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = null;
        int[] a = {1, 2, 3, 4, 5};
        for (int x : a) {
            head = createList(x, null);
        }
        traverseList(head);
        head = reverseList(head);
        traverseList(head);
    }
}
