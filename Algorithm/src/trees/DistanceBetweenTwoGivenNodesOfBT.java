package trees;

import static trees.LCAOfBinaryTree.findLCA;


public class DistanceBetweenTwoGivenNodesOfBT {

  private static int findLevel(Node root, Node target, int level) {
    if (root == null) {
      return 0;
    }
    if (root == target) {
      return level;
    }
    int distance = findLevel(root.left, target, level + 1);
    return distance == 0 ? findLevel(root.right, target, level + 1) : distance;
  }

  private static int findDistance(Node root, Node x, Node y) {
    Node lca = findLCA(root, x, y);
    return findLevel(lca, x, 0) + findLevel(lca, y, 0);
  }

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    System.out.println(findDistance(root, root.left.left, root.right));
  }
}
