package trees;

import static trees.TreeTraversal.inorder;

/* Two nodes of a BST are swapped, correct the BST
 * Input Tree:
 *          10
 *         /  \
 *        5    8
 *       / \
 *      2   20
 *
 * In the above tree, nodes 20 and 8 must be swapped to fix the tree.
 * Following is the output tree
 *          10
 *         /  \
 *        5    20
 *       / \
 *      2   8
 */
// Time Complexity: O(n)
public class RecoverBST {

  private static Node first, middle, last, temp;

  private static void recoverBSTUtil(Node root) {
    if (root == null) {
      return;
    }
    recoverBSTUtil(root.left);
    if (temp != null && root.num < temp.num) {
      if (first == null) {
        first = temp;
        middle = root;
      } else {
        last = root;
      }
    }
    temp = root;
    recoverBSTUtil(root.right);
  }

  private static void recoverBST(Node root) {
    recoverBSTUtil(root);
    if (first != null && last != null) {
      swap(first, last);
    } else if (first != null && middle != null) {
      swap(first, middle);
    }
  }

  private static void swap(Node x, Node y) {
    int t = x.num;
    x.num = y.num;
    y.num = t;
  }

  public static void main(String[] args) {
/*                       6
                        / \
                       10  2
                      / \ / \
                     1  3 7 12

                10 and 2 are swapped
*/
    Node root  = new Node(1);
    root.left  = new Node(2);
    root.right = new Node(3);
    System.out.println("Original Tree");
    inorder(root);
    recoverBST(root);
    System.out.println();
    System.out.println("Recovered Tree");
    inorder(root);
  }
}
