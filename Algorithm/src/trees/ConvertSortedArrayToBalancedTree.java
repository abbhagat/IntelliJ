package trees;

import static trees.TreeTraversal.inorder;

// Time Complexity: O(n)
public class ConvertSortedArrayToBalancedTree {

    private static Node sortedArrayToBST(int[] a, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node root  = new Node(a[mid]);
        root.left  = sortedArrayToBST(a, start, mid - 1);
        root.right = sortedArrayToBST(a, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7};
        Node root = sortedArrayToBST(a, 0, a.length - 1);
        inorder(root);
    }
}
