package doublylinkedlist;

import static doublylinkedlist.CreateList.createList;
import static doublylinkedlist.CreateList.last;
import static doublylinkedlist.TraverseList.traverseList;

public class QuickSort {

    private static Node partition(Node head, Node last) {
        int x  = head.num;
        Node i = last.left;                             // similar to i = last-1 for array implementation
        i = (i == null) ? last : i.right;         // Similar to i++
        int temp = i.num;
        i.num = head.num;
        head.num = temp;
        return i;
    }

    private static void quickSort(Node head, Node last) {
        if (head != null && last != head && last != head.right) {
            Node temp = partition(last, head);
            quickSort(last, temp.left);
            quickSort(temp.right, head);
        }
    }

    public static void main(String[] args) {
        Node head = null;
        int[] a = {10, 3, 4, 6, 9, 2, 1, 5, 8, 7};
        for (int x : a) {
            head = createList(x, null);
        }
        traverseList(head);
        quickSort(head, last);
        traverseList(head);
    }
}
