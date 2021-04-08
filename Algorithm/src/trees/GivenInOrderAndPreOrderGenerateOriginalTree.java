package trees;

public class GivenInOrderAndPreOrderGenerateOriginalTree {

    private static int preIndex = 0;

    public static BST buildTree(int[] inorder, int[] preorder, int start, int end) {

        if(start > end){
            return null;
        }

        BST root = new BST();
        root.num = preorder[preIndex++];
        root.left = null;
        root.right = null;

        if (start == end) {
            return root;
        }

        int index  = search(inorder, root.num, start, end);
        root.left  = buildTree(inorder, preorder, start, index - 1);
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
}
