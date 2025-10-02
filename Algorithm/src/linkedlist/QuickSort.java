package linkedlist;

import static linkedlist.LinkList.add;
import static linkedlist.TraverseList.traverseList;

public class QuickSort {

    private static Node partition(Node low, Node high) {
        int pivot = high.num;
        Node i = null;
        for (Node j = low; j != high; j = j.next) {
            if (j.num <= pivot) {  // j.num > pivot to sort in descending order
                i = (i == null) ? low : i.next;
                swap(i, j);
            }
        }
        i = (i == null) ? low : i.next;
        swap(i, high);
        return i;
    }

    private static void quickSort(Node low, Node high) {
        if (low != null && high != null && low != high && low != high.next) {
            Node pivot = partition(low, high);
            Node temp = low;
            while (temp.next != pivot) {
                   temp = temp.next;
            }
            quickSort(low, temp);
            quickSort(pivot.next, high);
        }
    }

    private static void swap(Node x, Node y) {
        int temp = x.num;
        x.num = y.num;
        y.num = temp;
    }

    public static void main(String[] args) {
        Node head = null;
        for (int x : new int[]{1, 3, 5, 2, 4, 7, 10, 6, 9, 8}) {
             head = add(head, x);
        }
        traverseList(head);
        quickSort(head, LinkList.last);
        traverseList(head);
    }
}
