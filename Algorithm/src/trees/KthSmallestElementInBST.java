package trees;

import static trees.CreateBST.createBST;

public class KthSmallestElementInBST {

    private static int k = 2;
    private static void findKthSmallest(Node root) {
        if (root != null) {
            findKthSmallest(root.left);
            k--;
            if (k == 0) {
                System.out.println(root.num);
            }
            findKthSmallest(root.right);
        }
    }

    public static void main(String[] args) {
        int[] a = {30, 10, 50, 5, 20, 40, 60};
        Node root = null;
        for (int x : a) {
            root = createBST(root, x);
        }
        findKthSmallest(root);
    }
}
