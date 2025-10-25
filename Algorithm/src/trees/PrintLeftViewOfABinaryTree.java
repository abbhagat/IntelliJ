package trees;

// Time Complexity: The function does a simple traversal of the tree, so the complexity is O(n)

public class PrintLeftViewOfABinaryTree {

  private static int max_level = 0;

  private static void printLeftView(Node root, int level) {
    if (root == null) {
        return;
    }
    if (max_level < level) {
      System.out.print(root.num + " ");
      max_level = level;
    }
    printLeftView(root.left,  level + 1);
    printLeftView(root.right, level + 1);
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

    Node root              = new Node(1);
    root.left              = new Node(2);
    root.right             = new Node(3);
    root.left.left         = new Node(4);
    root.left.right        = new Node(5);
    root.right.right       = new Node(6);
    root.left.right.left   = new Node(7);
    root.left.right.right  = new Node(8);
    root.right.right.right = new Node(9);
    root.right.right.right.right = new Node(10);
    printLeftView(root, 1);
  }
}
