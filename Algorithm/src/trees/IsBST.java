package trees;

// Time Complexity O(n)

import static trees.CreateBST.createBST;

public class IsBST {
    private static boolean isBST(Node root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.num < min || root.num > max) {
            return false;
        }
        return isBST(root.left, min, root.num) && isBST(root.right, root.num, max);
    }

    public static void main(String[] args) {
        int[] a = {30, 10, 50, 5, 20, 40, 60};
        Node root = null;
        for (int i = 0; i < a.length; i++) {
            root = createBST(root, a[i]);
        }
        System.out.println("Is BST :" + isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}
