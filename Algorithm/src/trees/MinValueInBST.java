package trees;

public class MinValueInBST {

    BST minValueinBST(BST root) {
        if (root != null) {
            while (root.left != null) {
                root = root.left;
            }
        }
        return root;
    }

    BST minValueBST(BST root) {
        if (root != null) {
            if (root.left != null) {
                root = minValueBST(root.left);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] a = { 10, 13, 5, 8, 9, 16, 20, 25, 4, 6, 7 };
        BST root = null;
        CreateBST bst = new CreateBST();
        for (int i = 0; i < a.length; i++) {
            root = bst.createBST(root, a[i]);
        }
        System.out.println(new MinValueInBST().minValueBST(root).num);
    }
}
