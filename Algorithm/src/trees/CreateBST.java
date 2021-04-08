package trees;

public class CreateBST {

    static BST createBST(BST root, int num) {

        if (root == null) {
            root = new BST();
            root.num = num;
            root.left = null;
            root.right = null;
        } else {
            if (num < root.num) {
                root.left = createBST(root.left, num);
            } else if (num > root.num) {
                root.right = createBST(root.right, num);
            }
        }
        return root;
    }
}
