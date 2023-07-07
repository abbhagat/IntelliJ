package doublylinkedlist;

import static doublylinkedlist.CreateList.createList;
import static doublylinkedlist.TraverseList.traverseList;

// Time complexity is O(n)
// Auxiliary space is O(1)
public class PairWithGivenSumInSortedDLL {

    private static void pairSum(Node low, Node high, final int x) {
        boolean found = false;
        // The loop terminates when they cross each other (high.right == low), or they become same (low == high)
        while (low != high && high.right != low) {
            if (low.num + high.num == x) {
                found = true;
                System.out.println("(" + low.num + ", " + high.num + ")");
                low  = low.right;              // move low in forward direction
                high = high.left;             // move high in backward direction
            } else {
                if (low.num + high.num < x) {
                    low  = low.right;
                } else {
                    high = high.left;
                }
            }
        }
        if (!found) {
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
        pairSum(head, CreateList.last, 7);
        System.out.println();
        pairSum(head, CreateList.last, 5);
    }
}
