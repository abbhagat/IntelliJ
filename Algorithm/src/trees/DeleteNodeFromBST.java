package trees;

public class DeleteNodeFromBST {

    BST deleteNodeFromBST(BST root, int num) {
        if (null == root) {
            return root;
        }
        if (num < root.num) {
            root.left = deleteNodeFromBST(root.left, num);
        } else if (num > root.num) {
            root.right = deleteNodeFromBST(root.right, num);
        } else {
            if (root.left == null) {
                BST temp = root.right;
                root = null;
                return temp;
            } else if (root.right == null) {
                BST temp = root.left;
                root = null;
                return temp;
            } else {
                BST temp = minValueNode(root.right);
                root.num = temp.num;
                root.right = deleteNodeFromBST(root.right, temp.num);
            }
        }
        return root;
    }

    private BST minValueNode(BST root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
