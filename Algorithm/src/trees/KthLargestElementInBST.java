package trees;

import static trees.CreateBST.createBST;

public class KthLargestElementInBST {

    private static int k = 2;

    private static void findKthLargest(Node root) {
        if (root != null) {
            findKthLargest(root.right);
            k--;
            if (k == 0) {
                System.out.println(root.num);
                return;
            }
            findKthLargest(root.left);
        }
    }

    public static void main(String[] args) {
        int[] a = {30, 10, 50, 5, 20, 40, 60};
        Node root = null;
        for (int x : a) {
            root = createBST(root, x);
        }
        findKthLargest(root);
    }
}
