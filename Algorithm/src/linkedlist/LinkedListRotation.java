package linkedlist;


/*
 *   Input ->  1 2 3 4 5 , k = 3
 *   Output -> 4 5 1 2 3
 */

public class LinkedListRotation {

    static Node rotateList(Node first, int k) {
        if (k > LinkList.size || LinkList.size == 0) {
            System.out.println("Rotation not possible");
        } else {
            Node temp = first, last;
            for (last = first; last.next != null; last = last.next) ;
            for (int i = 1; i < k; i++) {
                temp = temp.next;
            }
            last.next = first;
            first = temp.next;
            temp.next = null;

        }
        return first;
    }
}
