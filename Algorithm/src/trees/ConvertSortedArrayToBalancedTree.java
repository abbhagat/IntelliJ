package trees;

/*
Input:  Array {1, 2, 3}
Output: A Balanced BST
     2
   /  \
  1    3

Input: Array {1, 2, 3, 4}
Output: A Balanced BST
      3
    /  \
   2    4
 /
1

1) Get the Middle of the array and make it root.
2) Recursively do same for left half and right half.
      a) Get the middle of left half and make it left child of the root
          created in step 1.
      b) Get the middle of right half and make it right child of the
          root created in step 1.
 */

import static trees.TreeTraversal.inorder;

public class ConvertSortedArrayToBalancedTree {

    private static Node sortedArrayToBST(int arr[], int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node root  = new Node(arr[mid]);
        root.left  = sortedArrayToBST(arr, start, mid - 1);
        root.right = sortedArrayToBST(arr, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        int a[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        Node root = sortedArrayToBST(a, 0, a.length - 1);
        inorder(root);
    }
}
