package linkedlist;

import static linkedlist.LinkList.add;
import static linkedlist.TraverseList.traverseList;

// Time complexity: O(n)

public class DeleteRepeatedElementsInSortedList {

    private static void removeDuplicate(Node first) {
        for (Node prev = first, temp = first.next; temp != null; temp = temp.next) {
            if (prev.num == temp.num) {
                prev.next = temp.next;
            } else {
                prev = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 3, 3, 4, 5, 5};
        Node first = null;
        for (int x : a) {
            first = add(first, x);
        }
        removeDuplicate(first);
        traverseList(first);
    }
}
