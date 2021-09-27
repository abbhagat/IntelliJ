package trees;


import static trees.TreeTraversal.postorder;

class PostIndex {
    int index;
}

public class GivenInOrderAndPostOrderGenerateOriginalTree {

    public static Node buildTree(int[] inorder, int[] postOrder, int start, int end, PostIndex postIndex) {
        if (start > end) {
            return null;
        }

        Node root = new Node(postOrder[postIndex.index]);
        postIndex.index--;

        if (start == end) {
            return root;
        }

        int index  = search(inorder, root.num, start, end);
        root.right = buildTree(inorder, postOrder, index + 1, end, postIndex);
        root.left  = buildTree(inorder, postOrder, start, index - 1, postIndex);
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
        System.out.println();
        int[] inorder = {10, 8, 6, 4, 2, 1, 3, 5, 7, 9};
        int[] postorder = {10, 8, 6, 4, 2, 9, 7, 5, 3, 1};
        PostIndex postIndex = new PostIndex();
        postIndex.index = postorder.length - 1;
        Node root = buildTree(inorder, postorder, 0, inorder.length - 1, postIndex);
        postorder(root);
    }
}
