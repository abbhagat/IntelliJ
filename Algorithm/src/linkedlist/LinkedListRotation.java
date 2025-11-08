package linkedlist;

import static linkedlist.LinkList.add;
import static linkedlist.TraverseList.traverseList;

// Input ->  1 2 3 4 5 and k = 3  Output -> 4 5 1 2 3
// Time Complexity  : O(n)

public class LinkedListRotation {

    public static Node rotateList(Node first, int k) {
        if (first == null || first.next == null || k <= 0) {
            return first;
        }
        Node temp = first, last = first;
        while (last.next != null) {
            last = last.next;
        }
        for (int i = 1; i < k; i++) {
            temp = temp.next;
        }
        last.next = first;
        first = temp.next;
        temp.next = null;
        return first;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        Node first = null;
        for (int x : a) {
            first = add(first, x);
        }
        traverseList(first);
        traverseList(rotateList(first, 3));
    }
}
