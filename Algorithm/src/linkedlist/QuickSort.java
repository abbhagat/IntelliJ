package linkedlist;

import static linkedlist.LinkList.add;
import static linkedlist.TraverseList.traverseList;

public class QuickSort {

    private static Node partitionLast(Node start, Node end) {
        if (start == end || start == null || end == null) {
            return start;
        }
        Node pivot_prev = start;
        Node curr = start;
        int pivot = end.num;
        while (start != end) {               // iterate till one before the end, no need to iterate till the end because end is pivot
            if (start.num < pivot) {
                pivot_prev = curr;
                int temp = curr.num;
                curr.num = start.num;
                start.num = temp;
                curr = curr.next;
            }
            start = start.next;
        }
        int temp = curr.num;     // Swap the position of curr i.e. next suitable index and pivot
        curr.num = pivot;
        end.num  = temp;
        return pivot_prev;      // Return one previous to current because current is now pointing to pivot
    }

    private static void quickSort(Node start, Node end) {
        if (start == null || start == end || start == end.next) {
            return;
        }
        Node pivot_prev = partitionLast(start, end);     // Split list and partition recurse
        quickSort(start, pivot_prev);
        // If pivot is picked and moved to the start, that means start and pivot is same so pick from next of pivot
        if (pivot_prev != null && pivot_prev == start) {
            quickSort(pivot_prev.next, end);
        }
        // If pivot is in between of the list, start from next of pivot, since we have pivot_prev, so we move two nodes
        else if (pivot_prev != null && pivot_prev.next != null) {
            quickSort(pivot_prev.next.next, end);
        }
    }

    public static void main(String[] args) {
        Node head = null;
        for (int x : new int[]{1, 3, 5, 2, 4}) {
            head = add(head, x);
        }
        traverseList(head);
        System.out.println();
        quickSort(head, head.next.next.next.next);
        traverseList(head);
    }
}
