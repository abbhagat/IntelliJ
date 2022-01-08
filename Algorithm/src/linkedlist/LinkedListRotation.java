package linkedlist;

/*
 *   Input ->  1 2 3 4 5 , k = 3
 *   Output -> 4 5 1 2 3
 */

import static linkedlist.LinkList.add;
import static linkedlist.TraverseList.traverseList;

public class LinkedListRotation {

    public static Node rotateList(Node first, int k) {
        Node temp = first, last;
        for (last = first; last.next != null; last = last.next) ;
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
