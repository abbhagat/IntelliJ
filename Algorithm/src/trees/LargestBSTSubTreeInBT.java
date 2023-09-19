package trees;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

// Time Complexity O(n)
public class LargestBSTSubTreeInBT {
    private static class BST {
        int size;
        int min;
        int max;
        boolean isBST;

        BST() {
        }

        BST(int size, int max, int min, boolean isBST) {
            this.size = size;
            this.max = max;
            this.min = min;
            this.isBST = isBST;
        }
    }

    private static BST largestBST(Node root) {
        if (root == null) {
            return new BST(0, Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        }
        BST left  = largestBST(root.left);
        BST right = largestBST(root.right);
        BST bst   = new BST();
        bst.min   = min(left.min,  root.num);
        bst.max   = max(right.max, root.num);
        bst.isBST = left.isBST && right.isBST && root.num > left.max && root.num < right.min;
        bst.size  = bst.isBST ? left.size + right.size + 1 : max(left.size, right.size);
        return bst;
    }

    public static void main(String[] args) {
        final Node root = new Node(60);
        root.left       = new Node(65);
        root.right      = new Node(70);
        root.left.left  = new Node(50);
        System.out.print("Size of the largest BST is " + largestBST(root).size);
    }
}
