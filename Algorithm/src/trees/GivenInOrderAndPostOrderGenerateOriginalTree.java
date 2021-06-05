package trees;

class PostIndex {
    int postIndex;
}

public class GivenInOrderAndPostOrderGenerateOriginalTree {


    public static Node buildTree(int[] inorder, int[] postOrder, int start, int end, PostIndex postIndex) {

        if (start > end) {
            return null;
        }

        Node root = new Node();
        root.num = postOrder[postIndex.postIndex];
        (postIndex.postIndex)--;
        root.left = null;
        root.right = null;

        if (start == end) {
            return root;
        }
        int index = search(inorder, root.num, start, end);
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
}
