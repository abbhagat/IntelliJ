package linkedlist;

public class MergeSort {

    void mergeSort(Node head) {

        Node temp = head;
        Node a = null, b = null;
        // If the list has 0 or 1 node no need to sort
        if (temp == null || temp.next == null) {
            return;
        }
        // Diving the list into 2 equal halves
        partition(temp, a, b);
        mergeSort(a);
        mergeSort(b);
        head = merge(a, b);
    }

    void partition(Node temp, Node a, Node b) {

    }

    Node merge(Node a, Node b) {
        return null;
    }
}
