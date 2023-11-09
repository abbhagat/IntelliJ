package doublylinkedlist;

import static doublylinkedlist.CreateList.createList;
import static doublylinkedlist.TraverseList.traverseList;

// Time Complexity: O(N), where N denotes the number of nodes in the doubly linked list.
// Auxiliary Space: O(1)
public class ReverseList {

    private static Node reverseList(Node head) {
        Node temp = null, node = head;
        while (node != null) {        // swap(node.left, node.right)
            temp = swap(node);
            node = node.left;
        }
        if (temp != null) {         // Before changing head, check for the cases like empty list and list with only one node
            head = temp.left;
        }
        return head;
    }

    private static Node reverse(Node node) {
        if (node == null) {
            return null;
        }
        swap(node);
        if (node.left == null) {
            return node;
        }
        return reverse(node.left);
    }

    private static Node swap(Node node) {
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
        return temp;
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
        head = reverse(head);
        traverseList(head);
    }
}
