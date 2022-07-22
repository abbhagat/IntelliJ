package linkedlist;

/* Given the head of a linked list and a numue x, partition it such that all nodes less than x come
 before nodes greater than or equal to x
*/

import static linkedlist.TraverseList.traverseList;

public class PartitionList {

    private static Node partition(Node head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = partition(head.next, x);
        if (head.num < x) {
            return head;
        } else {
            Node temp = head;
            while (temp.next != null) {
                if (temp.num > temp.next.num && temp.next.num < x) {
                    int t = temp.num;
                    temp.num = temp.next.num;
                    temp.next.num = t;
                    temp = temp.next;
                } else {
                    break;
                }
            }
        }
        return head;
    }

// Time Complexity:  O(N)
// Space Complexity: O(1)
    public static Node partitions(Node head, int x) {
        // before and after are the two pointers used to create the two list before_head and after_head are used to save the heads of the two lists.
        // All of these are initialized with the dummy nodes created.
        Node before_head = new Node(0, head);
        Node before = before_head;
        Node after_head = new Node(0, head);
        Node after = after_head;
        while (head != null) {
            // If the original list node is lesser than the given x assign it to the before list.
            if (head.num < x) {
                before.next = head;
                before = before.next;
            } else {
                // If the original list node is greater or equal to the given x, assign it to the after list.
                after.next = head;
                after = after.next;
            }
            // move ahead in the original list
            head = head.next;
        }
        // Last node of "after" list would also be ending node of the reformed list
        after.next = null;
        // Once all the nodes are correctly assigned to the two lists, combine them to form a single list which would be returned.
        before.next = after_head.next;
        return before_head.next;
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 3, 2, 5, 2};
        Node first = null;
        for (int x : a) {
            first = LinkList.add(first, x);
        }
        traverseList(first);
        first = partitions(first, 3);
        traverseList(first);
    }
}
