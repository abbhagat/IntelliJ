package trees;

// Time Complexity: O(n) where n is the number of nodes in binary tree.
// Auxiliary Space: O(n)
public class PrintBoundaryNodesOfATree {

  private static void printLeafNodes(Node root) {
    if (root != null) {
      printLeafNodes(root.left);
      printLeafNodes(root.right);
      if (root.left == null && root.right == null) {
        System.out.print(root.num + " ");
      }
    }
  }

  private static void printLeftEdgeNodes(Node root) {
    if (root.left != null) {
      System.out.print(root.num + " ");
      printLeftEdgeNodes(root.left);
    }
  }

  private static void printRightEdgeNodes(Node root) {
    if (root.right != null) {
      System.out.print(root.num + " ");
      printRightEdgeNodes(root.right);
    }
  }

  private static void printBoundary(Node root) {
    printLeafNodes(root);
    System.out.println();
    printLeftEdgeNodes(root);
    System.out.println();
    printRightEdgeNodes(root.right);
  }

  public static void main(String[] args) {
       /*
                     1
                 /      \
                2        3
              /   \       \
             4     5       6
                  / \      \
                 7  8       9
                             \
                             10
        */
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.right = new Node(6);
    root.left.right.left = new Node(7);
    root.left.right.right = new Node(8);
    root.right.right.right = new Node(9);
    root.right.right.right.right = new Node(10);
    printBoundary(root);
  }
}
