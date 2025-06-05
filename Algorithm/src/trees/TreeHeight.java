package trees;

import static java.lang.Math.max;

// Time  Complexity: O(n)
// Space Complexity: O(2^h) - 1
public class TreeHeight {

    public static int treeHeight(Node root) {
        return null == root ? 0 : max(treeHeight(root.left), treeHeight(root.right)) + 1;
    }

    public static int heights(Node root) {
        if (root == null) {
            return 0;
        }
        int lH = heights(root.left);
        int rH = heights(root.right);
        return max(lH, rH) + 1;
    }

    public static void main(String[] args) {
         /*
                                1
                            /      \
                           2        3
                         /   \       \
                        4     5       6
                             / \      \
                            7  8       9
                                        \
                                        10
         */
        Node root              = new Node(1);
        root.left              = new Node(2);
        root.right             = new Node(3);
        root.left.left         = new Node(4);
        root.left.right        = new Node(5);
        root.right.right       = new Node(6);
        root.left.right.left   = new Node(7);
        root.left.right.right  = new Node(8);
        root.right.right.right = new Node(9);
        System.out.println("Tree Height " + treeHeight(root));
        System.out.println("Tree Height " + heights(root));
    }
}
