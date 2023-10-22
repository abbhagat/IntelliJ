package trees;

/*
For two trees ‘a’ and ‘b’ to be mirror images, the following three conditions must be true:
1. Their root node’s key must be same
2. Left subtree of root of ‘a’ and right subtree root of ‘b’ are mirror.
3. Right subtree of ‘a’ and left subtree of ‘b’ are mirror.
*/

import static trees.TreeTraversal.inorder;

// Time Complexity : O(n)
public class IsMirrorImage {

    private static boolean isMirrorImage(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return root1.num == root2.num && isMirrorImage(root1.left, root2.right) && isMirrorImage(root1.right, root2.left);
    }

    public static void main(String[] args) {
        /*

                 1              1
                / \            / \
               2   3          3   2
              / \                / \
             4   5              5   4
         */
        Node root1       = new Node(1);
        root1.left       = new Node(2);
        root1.right      = new Node(3);
        root1.left.left  = new Node(4);
        root1.left.right = new Node(5);
        inorder(root1);
        System.out.println();
        Node root2        = new Node(1);
        root2.left        = new Node(3);
        root2.right       = new Node(2);
        root2.right.left  = new Node(5);
        root2.right.right = new Node(4);
        inorder(root2);
        System.out.println();
        System.out.println(isMirrorImage(root1, root2) ? "Mirror Image" : "Not a Mirror Image");
    }
}
