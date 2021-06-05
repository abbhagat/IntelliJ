package trees;

public class DeleteNodeFromBST {

    Node deleteNodeFromBST(Node root, int num) {
        if (null == root) {
            return root;
        }
        if (num < root.num) {
            root.left = deleteNodeFromBST(root.left, num);
        } else if (num > root.num) {
            root.right = deleteNodeFromBST(root.right, num);
        } else {
            if (root.left == null) {
                Node temp = root.right;
                root = null;
                return temp;
            } else if (root.right == null) {
                Node temp = root.left;
                root = null;
                return temp;
            } else {
                Node temp = minValueNode(root.right);
                root.num = temp.num;
                root.right = deleteNodeFromBST(root.right, temp.num);
            }
        }
        return root;
    }

    private Node minValueNode(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
