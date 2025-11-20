package trees;

import static trees.TreeTraversal.inorder;
/*  Input:  root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
 *  Output: [3,4,5,5,4,null,7]
 *  Input:  root1 = [1], root2 = [1,2]
 *  Output: [2,2]
 */
// Time  Complexity = O(n + m)
// Space Complexity = O(N)
public class MergeTwoBST {

  private static Node mergeTrees(Node root1, Node root2) {
    if (root1 != null && root2 != null) {
      Node root  = new Node(root1.num + root2.num);
      root.left  = mergeTrees(root1.left, root2.left);
      root.right = mergeTrees(root1.right, root2.right);
      return root;
    }
    return root1 != null ? root1 : root2;
  }

  public static void main(String[] args) {
    Node root1        = new Node(1);
    root1.left        = new Node(3);
    root1.right       = new Node(2);
    root1.left.left   = new Node(5);

    Node root2        = new Node(2);
    root2.left        = new Node(1);
    root2.right       = new Node(3);
    root2.left.right  = new Node(4);
    root2.right.right = new Node(7);

    Node root = mergeTrees(root1, root2);
    inorder(root);
  }
}
