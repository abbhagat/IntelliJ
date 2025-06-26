package linkedlist;

import static linkedlist.LinkList.add;
import static linkedlist.TraverseList.traverseList;

public class QuickSort {

    private static Node partitionLast(Node start, Node end) {
        if (start == end || start == null || end == null) {
            return start;
        }
        Node prevPivot = start;
        Node curr      = start;
        int pivot      = end.num;
        while (start != end) {               // iterate till one before the end, no need to iterate till the end because the end is pivot
            if (start.num < pivot) {
                prevPivot  = curr;
                // swap(current, start)
                int temp   = curr.num;
                curr.num   = start.num;
                start.num  = temp;
                curr       = curr.next;
            }
            start = start.next;
        }
        int temp = curr.num;     // Swap the position of curr i.e., next suitable index and pivot
        curr.num = pivot;
        end.num  = temp;
        return prevPivot;      // Return one previous to current because current is now pointing to pivot
    }

    private static void quickSort(Node start, Node end) {
        if (start == null || start == end || start == end.next) {
            return;
        }
        Node prevPivot = partitionLast(start, end);     // Split list and partition recurse
        quickSort(start, prevPivot);
        // If pivot is picked and moved to the start, that means start and pivot is the same so pick from next of pivot
        if (prevPivot != null && prevPivot == start) {
            quickSort(prevPivot.next, end);
        }
        // If pivot is in between of the list, start from next of pivot, since we have prevPivot, so we move two nodes
        else if (prevPivot != null && prevPivot.next != null) {
            quickSort(prevPivot.next.next, end);
        }
    }

    public static void main(String[] args) {
        Node head = null;
        for (int x : new int[]{1, 3, 5, 2, 4}) {
             head = add(head, x);
        }
        traverseList(head);
        quickSort(head, head.next.next.next.next);
        traverseList(head);
    }
}
