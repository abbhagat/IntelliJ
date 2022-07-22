package trees;

import static trees.CreateBST.createBST;

public class KthSmallestElementInBST {

    private static int k = 1;
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
        for (int i = 0; i < a.length; i++) {
            root = createBST(root, a[i]);
        }
        findKthSmallest(root);
    }
}
