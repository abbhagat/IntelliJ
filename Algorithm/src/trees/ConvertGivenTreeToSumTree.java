package trees;

import static trees.TreeTraversal.inorder;

/**
Given a Binary Tree where each node has positive and negative values.
Convert this to a tree where each node contains the sum of the left and right subtree in the original tree.
The values of leaf nodes are changed to 0.
For example, the following tree
                                         10
                                      /      \
                                    -2        6
                                  /   \      /  \
                                8     -4    7    5
                                should be changed to
                                         20[(-4+8-2) + (7+5+6)]
                                       /      \
                                 4(8-4)      12(7+5)
                                   /   \      /  \
                                 0      0    0    0
Inorder:- 0 4 0 20 0 12 0
*/

// Time Complexity: O(n)
public class ConvertGivenTreeToSumTree {

    private static int convert(Node root) {
        if (root == null) {
            return 0;
        }
        int oldVal   = root.num;
        int leftSum  = convert(root.left);
        int rightSum = convert(root.right);
        root.num = leftSum + rightSum;
        return root.num + oldVal;
    }

    public static void main(String[] args) {
        Node root  = new Node(2);
        root.left  = new Node(1);
        root.right = new Node(3);
        convert(root);
        inorder(root);
    }
}
