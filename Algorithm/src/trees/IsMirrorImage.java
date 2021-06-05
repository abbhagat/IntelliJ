package trees;


import static trees.CreateBST.createBST;
import static trees.TreeMirrorImage.mirrorImage;
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
        int[] a = {5, 3, 6, 2, 4};
        Node root = null;
        for (int i = 0; i < a.length; i++) {
            root = createBST(root, a[i]);
        }
        inorder(root);
        Node mirrorRoot = mirrorImage(root);
        System.out.println();
        inorder(mirrorRoot);
        System.out.println(isMirrorImage(root, mirrorRoot) ? "Mirror Image" : "Not a Mirror Image");
    }
}
