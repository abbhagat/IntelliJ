package trees;

// Time Complexity: The function does a simple traversal of the tree, so the complexity is O(n)
public class PrintRightViewOfABinaryTree {

  private static int max_level = 0;

  private static void printRightView(Node root, int level) {
    if (root == null) {
      return;
    }
    if (max_level < level) {
      System.out.print(" " + root.num);
      max_level = level;
    }
    printRightView(root.right, level + 1);
    printRightView(root.left,  level + 1);
  }

  public static void main(String[] args) {
    Node root                    = new Node(1);
    root.right                   = new Node(2);
    root.right.right             = new Node(3);
    root.right.right.right       = new Node(4);
    root.right.right.right.right = new Node(5);
    root.left                    = new Node(6);
    printRightView(root, 1);
  }
}
