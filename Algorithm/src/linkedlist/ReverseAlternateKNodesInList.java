package linkedlist;

import static linkedlist.LinkList.add;
import static linkedlist.TraverseList.traverseList;

public class ReverseAlternateKNodesInList {

    private static Node reverse(Node head, int k) {
        Node current = head, next, prev = null;
        int count = 0;
        while (current != null && count < k) {   // reverse first k nodes of the linked list
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        if (head != null) {        // Now head points to the kth head. So change next of head to (k+1)th head
            head.next = current;
        }
        // We do not want to reverse next k nodes. So move the current pointer to skip next k nodes
        count = 0;
        while (count < k - 1 && current != null) {
            current = current.next;
            count++;
        }
        // Recursively call for the list starting from current->next And make rest of the list as next of first head
        if (current != null) {
            current.next = reverse(current.next, k);
        }
        return prev;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Node first = null;
        for (int x : a) {
            first = add(first, x);
        }
        traverseList(first);
        first = reverse(first, 3);
        traverseList(first);
    }
}
