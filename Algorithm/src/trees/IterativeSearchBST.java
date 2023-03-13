package trees;

import static trees.CreateBST.createBST;

public class IterativeSearchBST {

    public static Node searchBST(Node root, int num) {
        while (root != null) {
            if (root.num == num) {
                return root;
            }
            root = num < root.left.num ? root.left : root.right;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] a = {30, 10, 50, 5, 20, 40, 60, 1};
        Node root = null;
        for (int i = 0; i < a.length; i++) {
            root = createBST(root, a[i]);
        }
        System.out.println(searchBST(root, 50));
    }
}
