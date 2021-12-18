package trees;

import static trees.CreateBST.createBST;

public class MinValueInBST {

    public static Node minValueInBST(Node root) {
        while (null != root && null != root.left) {
            root = root.left;
        }
        return root;
    }

    public static Node minValueBST(Node root) {
        if (null != root && null != root.left) {
            root = minValueBST(root.left);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] a = {10, 13, 5, 8, 9, 16, 20, 25, 4, 6, 7};
        Node root = null;
        for (int i = 0; i < a.length; i++) {
            root = createBST(root, a[i]);
        }
        System.out.println(minValueBST(root).num);
        System.out.println(minValueInBST(root).num);
    }
}
