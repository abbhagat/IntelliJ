package trees;

public class TreeMirrorImage {

    public static Node mirrorImage(Node root) {
        if (root == null) {
            return root;
        }
        Node left = mirrorImage(root.left);
        Node right = mirrorImage(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
