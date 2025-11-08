package trees;

import static trees.CreateBST.createBST;

public class MinValueInBST {

    public static Node minValueInBST(Node root) {
        while (root != null && root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static Node minValueBST(Node root) {
        if (root != null && root.left != null) {
            root = minValueBST(root.left);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] a = {10, 13, 5, 8, 9, 16, 20, 25, 4, 6, 7};
        Node root = null;
        for (int x : a) {
            root = createBST(root, x);
        }
        System.out.println(minValueBST(root).num);
        System.out.println(minValueInBST(root).num);
    }
}
