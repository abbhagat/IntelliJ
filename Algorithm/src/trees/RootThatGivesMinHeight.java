package trees;

import static java.lang.Integer.max;

public class RootThatGivesMinHeight {

  private static int max = Integer.MIN_VALUE;
  private static Node minHeightNode;

  private static int treeHeight(Node root) {
    if (root == null) {
      return 0;
    }
    int lh = treeHeight(root.left);
    int rh = treeHeight(root.right);
    int height = max(lh, rh) + 1;
    if (max < height) {
      max = height;
      minHeightNode = root;
    }
    return height;
  }

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    treeHeight(root);
    System.out.println(minHeightNode.num);
  }
}
