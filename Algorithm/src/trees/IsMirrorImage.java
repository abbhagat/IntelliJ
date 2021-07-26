package trees;

/*
For two trees ‘a’ and ‘b’ to be mirror images, the following three conditions must be true:


Their root node’s key must be same
Left subtree of root of ‘a’ and right subtree root of ‘b’ are mirror.
Right subtree of ‘a’ and left subtree of ‘b’ are mirror.
 */
// Time Complexity : O(n)

import static trees.BinaryTree.createBT;
import static trees.TreeMirrorImage.mirrorImageUsingIteration;
import static trees.TreeTraversal.inorder;

public class IsMirrorImage {

    static boolean isMirrorImage(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return root1.num == root2.num && isMirrorImage(root1.left, root2.right) && isMirrorImage(root1.right, root2.left);
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        Node root = null;
        for (int i = 0; i < a.length; i++) {
            root = createBT(a[i], root);
        }
        inorder(root);
        Node mirrorRoot = mirrorImageUsingIteration(root);
        System.out.println();
        inorder(mirrorRoot);
        System.out.println(isMirrorImage(root, mirrorRoot) ? "Mirror Image" : "Not a Mirror Image");
    }
}
