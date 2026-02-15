package trees;

import static java.lang.Integer.max;

public class TreeHeightOfEachNode {

  private static int treeHeight(Node root) {
    if (root == null) {
      return 0;
    }
    int lH = treeHeight(root.left);
    int rH = treeHeight(root.right);
    int height = max(lH, rH) + 1;
    System.out.println("Height of Root at Node " + root.num + " --> " + height);
    return height;
  }

  public static void main(String[] args) {
    Node root       = new Node(1);
    root.left       = new Node(2);
    root.right      = new Node(3);
    root.left.left  = new Node(4);
    root.left.right = new Node(5);
    treeHeight(root);
  }
}
