package trees;

import static trees.CreateBST.createBST;

public class IterativeSearchBST {

    public static Node searchBST(Node root, int num) {
        while (root != null) {
            if (root.num == num) {
                return root;
            }
            root = num < root.num ? root.left : root.right;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] a = {30, 10, 50, 5, 20, 40, 60, 1};
        Node root = null;
        for (int x : a) {
            root = createBST(root, x);
        }
        System.out.println(searchBST(root, 50));
    }
}
