package doublylinkedlist;

import static doublylinkedlist.CreateList.createList;
import static doublylinkedlist.TraverseList.traverseList;

// Time Complexity: O(n log n)
// Auxiliary Space: O(1)
public class MergeSort {

    private static Node findMid(Node first) {
        Node slow = first, fast = first.right;
        while (fast != null && fast.right != null) {
            slow = slow.right;
            fast = fast.right.right;
        }
        return slow;
    }

    private static Node mergeSort(Node head) {
        if (head == null || head.right == null) {
            return head;
        }
        Node mid = findMid(head);
        Node second = mid.right;
        mid.right = null;
        Node a = mergeSort(head);
        Node b = mergeSort(second);
        return merge(a, b);
    }

    private static Node merge(Node a, Node b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        if (a.num < b.num) {
            a.right = merge(a.right, b);
            a.right.left = a;
            a.left = null;
            return a;
        } else {
            b.right = merge(a, b.right);
            b.right.left = b;
            b.left = null;
            return b;
        }
    }

    public static void main(String[] args) {
        Node head = null;
        for (int x : new int[]{1, 3, 5, 2, 4}) {
            head = createList(x, null);
        }
        traverseList(head);
        System.out.println();
        head = mergeSort(head);
        traverseList(head);
    }
}
