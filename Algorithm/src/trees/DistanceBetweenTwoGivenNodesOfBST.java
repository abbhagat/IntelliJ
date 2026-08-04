package trees;

import static trees.BinaryTree.createBST;
import static trees.LCA.lca;

public class DistanceBetweenTwoGivenNodesOfBST {

  private static int findLevel(Node root, int target, int level) {
    if (root == null) {
      return 0;
    }
    if (root.num == target) {
      return level;
    }
    int distance = findLevel(root.left,  target, level + 1);
    if (distance == 0) {
        distance = findLevel(root.right, target, level + 1);
    }
    return distance;
  }

  private static int findDistance(Node root, int num1, int num2) {
    Node lca = lca(root, num1, num2);
    return findLevel(lca, num1, 0) + findLevel(lca, num2, 0);
  }

  public static void main(String[] args) {
    Node root = createBST();
    System.out.println(findDistance(root, 1, 7));
    System.out.println(findDistance(root, 3,  6));
    System.out.println(findDistance(root, 2,  5));
  }
}
