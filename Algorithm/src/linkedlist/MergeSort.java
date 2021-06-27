package linkedlist;

import static linkedlist.MidPointOfLinkedList.findMid;

public class MergeSort {

    private static Node mergeSort(Node head) {
        if (head.next == null) {
            return head;
        }
        Node mid = findMid(head);
        Node head2 = mid.next;
        mid.next = null;
        Node newHead1 = mergeSort(head);
        Node newHead2 = mergeSort(head2);
        Node finalHead = merge(newHead1, newHead2);
        return finalHead;
    }

    private static Node merge(Node head1, Node head2) {
        Node merged = new Node();
        Node temp = merged;

        while (head1 != null && head2 != null) {
            if (head1.num < head2.num) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return merged.next;
    }
    
    public static void main(String[] args) {
        Node head = null;
        for (int x : new int[]{1, 3, 5, 2, 4}) {
            head = LinkList.add(x, null);
        }
        TraverseList.traverseList(head);
        System.out.println();
        head = mergeSort(head);
        TraverseList.traverseList(head);
    }
}

