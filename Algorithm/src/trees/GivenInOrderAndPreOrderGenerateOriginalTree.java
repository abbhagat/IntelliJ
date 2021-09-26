package trees;

import static trees.TreeTraversal.preorder;

public class GivenInOrderAndPreOrderGenerateOriginalTree {

    private static int preIndex = 0;

    public static Node buildTree(int[] inorder, int[] preorder, int start, int end) {

        if (start > end) {
            return null;
        }

        Node root = new Node();
        root.num = preorder[preIndex++];
        root.left = null;
        root.right = null;

        if (start == end) {
            return root;
        }

        int index = search(inorder, root.num, start, end);
        root.left = buildTree(inorder, preorder, start, index - 1);
        root.right = buildTree(inorder, preorder, index + 1, end);
        return root;
    }

    private static int search(int[] inorder, int num, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == num) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] inorder = {10, 8, 6, 4, 2, 1, 3, 5, 7, 9};
        int[] preorder = {1, 2, 4, 6, 8, 10, 3, 5, 7, 9};
        Node root = buildTree(inorder, preorder, 0, inorder.length - 1);
        preorder(root);
    }
}
