package linkedlist;

// Time complexity: O(n log n) where n is the number of nodes in Linked List.

import static linkedlist.LinkList.add;
import static linkedlist.MidPointOfLinkedList.findMidPoint;

class TreeNode {
    int num;
    TreeNode left, right;

    TreeNode(int num) {
        this.num = num;
        left = null;
        right = null;
    }
}

public class ConvertSortedListToBalancedTree {

    public static TreeNode sortedListToBST(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.num);
        }
        Node prevMid = findMidPoint(head);
        Node mid = prevMid.next;
        prevMid.next = null;
        TreeNode root = new TreeNode(mid.num);
        root.left  = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }

    private static void preOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.num + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        Node first = null;
        for (int x : a) {
            first = add(first, x);
        }
        TreeNode root = sortedListToBST(first);
        preOrder(root);
    }
}
