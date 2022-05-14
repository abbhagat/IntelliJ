package doublylinkedlist;

import static doublylinkedlist.CreateList.createList;
import static doublylinkedlist.TraverseList.traverseList;

// Time complexity is O(n)
// Auxiliary space is O(1)
public class PairWithGivenSumInSortedDLL {

    private static void pairSum(Node head, int x) {
        Node first = head, second = head;
        while (second.right != null) {
            second = second.right;
        }
        boolean found = false;
        // The loop terminates when they cross each other (second.right == first), or they become same (first == second)
        while (first != second && second.right != first) {
            if (first.num + second.num == x) {
                found = true;
                System.out.println("(" + first.num + ", " + second.num + ")");
                first  = first.right;              // move first in forward direction
                second = second.left;             // move second in backward direction
            } else {
                if (first.num + second.num < x) {
                    first  = first.right;
                } else {
                    second = second.left;
                }
            }
        }
        if (found == false) {
            System.out.println("No pair found");
        }
    }

    public static void main(String[] args) {
        Node head = null;
        int[] a = {1, 2, 3, 4, 5, 6, 8, 9};
        for (int x : a) {
            head = createList(x, null);
        }
        traverseList(head);
        pairSum(head, 7);
    }
}
