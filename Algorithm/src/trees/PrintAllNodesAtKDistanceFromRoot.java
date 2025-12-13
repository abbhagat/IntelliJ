package trees;

// Time  Complexity: O(n) n is number of nodes in the given binary tree.
// Space Complexity: O(H) H is the height of the binary tree.
public class PrintAllNodesAtKDistanceFromRoot {

  private static void printKDistNodes(Node root, int level) {
    if (root == null || level < 0) {
      return;
    }
    if (level == 0) {
      System.out.print(root.num + " ");
      return;
    }
    printKDistNodes(root.left,  level - 1);
    printKDistNodes(root.right, level - 1);
  }

  public static void main(String[] args) {
        /*
                     1
                    / \
                   2   3
                  / \
                 4   5
                /
               6
        */
    Node root           = new Node(1);
    root.left           = new Node(2);
    root.right          = new Node(3);
    root.left.left      = new Node(4);
    root.left.right     = new Node(5);
    root.left.left.left = new Node(6);
    printKDistNodes(root, 0);
    System.out.println();
    printKDistNodes(root, 1);
    System.out.println();
    printKDistNodes(root, 2);
    System.out.println();
    printKDistNodes(root, 3);
  }
}
