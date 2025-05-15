package doublylinkedlist;

import static doublylinkedlist.CreateList.createList;
import static doublylinkedlist.CreateList.last;
import static doublylinkedlist.TraverseList.traverseList;

public class QuickSort {

    private static Node partition(Node low, Node high) {
        int pivot = high.num;
        Node i = low.left;
        for (Node j = low; j != high; j = j.right) {
            if (j.num <= pivot) {
                i = (i == null) ? low : i.right;
                int temp = i.num;
                i.num = j.num;
                j.num = temp;
            }
        }
        i = (i == null) ? low : i.right;
        int temp = i.num;
        i.num = high.num;
        high.num = temp;
        return i;
    }

    private static void quickSort(Node low, Node high) {
        if (low != null && high != null && low != high && low != high.right) {
            Node pivot = partition(low, high);
            quickSort(low, pivot.left);
            quickSort(pivot.right, high);
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
