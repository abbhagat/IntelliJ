package trees;

import static trees.TreeTraversal.inorder;

/**
 * Given a Binary Tree where each node has positive and negative values.
 * Convert this to a tree where each node contains the sum of the left and right subtrees in the original tree.
 * The values of leaf nodes are changed to 0.
 * For example, the following tree

 *                  10
 *                /   \
 *              -2     6
 *             / \   /  \
 *            8  4  7   5
 * should be changed to

 *                  20(4-2+12+6)
 *                /      \
 *          4(8-4)      12(7+5)
 *            /   \      /  \
 *          0      0    0    0

 * Inorder :- 0 4 0 20 0 12 0
 * Do a traversal of the given tree. In the traversal, store the old value of the current node,
 * recursively call for left and right subtrees and change the value of current node as sum of
 * the values returned by the recursive calls. Finally return the sum of new value and value
 * (which is sum of values in the subtree rooted with this node).
 */

// Time Complexity: O(n)
public class ConvertGivenTreeToSumTree {

    private static int convert(Node root) {
        if (root != null) {
            int oldVal = root.num;
            int leftSum = convert(root.left);
            int rightSum = convert(root.right);
            root.num = leftSum + rightSum;
            return root.num + oldVal;
        }
        return 0;
    }

    public static void main(String[] args) {
        Node root        = new Node(10);
        root.left        = new Node(-2);
        root.right       = new Node(6);
        root.left.left   = new Node(8);
        root.left.right  = new Node(-4);
        root.right.left  = new Node(7);
        root.right.right = new Node(5);
        convert(root);
        inorder(root);
    }
}
