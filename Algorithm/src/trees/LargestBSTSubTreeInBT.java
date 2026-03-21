package trees;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

// Time Complexity O(n)
public class LargestBSTSubTreeInBT {

  private static int maxSize = Integer.MIN_VALUE;

  private static class BST {
    boolean isBST;
    int min, max, size;

    public BST() {
      this.isBST = false;
      this.min = Integer.MAX_VALUE;
      this.max = Integer.MIN_VALUE;
      this.size = 0;
    }
  }

  private static BST largestBSTSubtree(Node root) {
    BST bst = new BST();
    if (root == null) {
      bst.isBST = true;
      return bst;
    }
    BST leftBST  = largestBSTSubtree(root.left);
    BST rightBST = largestBSTSubtree(root.right);
    if (leftBST.isBST && rightBST.isBST && leftBST.max < root.num && root.num < rightBST.min) {
      bst.isBST = true;
      bst.min   = min(root.num, leftBST.min);
      bst.max   = max(root.num, rightBST.max);
      bst.size  = leftBST.size + rightBST.size + 1;
      maxSize   = max(maxSize, bst.size);
    }
    return bst;
  }

  public static void main(String[] args) {
    Node root        = new Node(10);
    root.left        = new Node(5);
    root.right       = new Node(15);
    root.left.left   = new Node(1);
    root.left.right  = new Node(8);
    root.right.right = new Node(7);
    largestBSTSubtree(root);
    System.out.print("Size of the largest BST is " + maxSize);
  }

}
