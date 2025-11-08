package trees;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

// Time Complexity O(n)
public class LargestBSTSubTreeInBT {

    private static int maxSize = Integer.MIN_VALUE;

    private static BST largestBSTSubtree(Node root) {
        BST bst = new BST();
        if (root == null) {
            bst.isBST = true;
            return bst;
        }
        BST left = largestBSTSubtree(root.left);
        BST right = largestBSTSubtree(root.right);
        if (left.isBST && right.isBST && left.max < root.num && root.num < right.min) {
            bst.isBST = true;
            bst.min = min(root.num, left.min);
            bst.max = max(root.num, right.max);
            bst.size = left.size + right.size + 1;
            maxSize = max(maxSize, bst.size);
        }
        return bst;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(1);
        root.left.right = new Node(8);
        root.right.right = new Node(7);
        largestBSTSubtree(root);
        System.out.print("Size of the largest BST is " + maxSize);
    }

    private static class BST {
        boolean isBST;
        int min, max, size;

        public BST() {
            this.isBST = false;
            this.min = Integer.MAX_VALUE;
            this.max = Integer.MIN_VALUE;
            this.size = 0;
        }
    }
}
