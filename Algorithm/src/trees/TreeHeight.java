package trees;

import static java.lang.Math.max;

// Time Complexity : O(n)
// Space Complexity: O(2^h) - 1
public class TreeHeight {

    private static int lH, rH;

    public static int treeHeight(Node root) {
        return null == root ? -1 : max(treeHeight(root.left), treeHeight(root.right)) + 1;
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null) {
            lH++;
            height(root.left);
        }
        if (root.right != null) {
            rH++;
            height(root.right);
        }
        return max(lH, rH);
    }

    public static int heights(Node root) {
        if (root == null) {
            return -1;
        }
        int lH = heights(root.left);
        int rH = heights(root.right);
        return Integer.max(lH, rH) + 1;
    }

    public static void main(String[] args) {
        Node root           = new Node(1);
        root.left           = new Node(2);
        root.right          = new Node(3);
        root.left.left      = new Node(4);
        root.left.right     = new Node(5);
        System.out.println("Tree Height :" + treeHeight(root));
        System.out.println("Tree Height :" + treeHeight(null));
        System.out.println("Tree Height :" + height(root));
        System.out.println("Tree Height :" + height(null));
        System.out.println("Tree Height :" + heights(root));
        System.out.println("Tree Height :" + heights(null));
    }
}
