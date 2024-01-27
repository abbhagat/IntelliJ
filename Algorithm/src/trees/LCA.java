package trees;

import static trees.CreateBST.createBST;

// Time Complexity: O(h) h = Height of the BST
// Auxiliary Space: O(h) h = Height of the BST
public class LCA {

    public static Node lca(Node root, int num1, int num2) {
        if (root == null) {
            return null;
        }
        if ((num1 < root.num && num2 > root.num) || (num1 > root.num && num2 < root.num)) {
            return root;
        }
        if (num1 < root.num && num2 < root.num) {
            return lca(root.left, num1, num2);
        }
        if (num1 > root.num && num2 > root.num) {
            return lca(root.right, num1, num2);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] a = {30, 10, 50, 5, 20, 40, 60, 1, 6};
        Node root = null;
        for (int x : a) {
            root = createBST(root, x);
        }
        Node lca = lca(root, 1, 20);
        System.out.println(lca.num);
    }
}
