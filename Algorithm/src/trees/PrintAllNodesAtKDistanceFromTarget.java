package trees;

// Time Complexity: O(n)
public class PrintAllNodesAtKDistanceFromTarget {

  private static int printKDistanceNode(Node root, Node target, int k) {
    if (root == null) {
      return -1;
    }
    if (root == target) {
      printKDistanceNodeDown(root, k);
      return 0;
    }
    int dl = printKDistanceNode(root.left, target, k);  // dl is the distance of root's left child from target
    if (dl != -1) {
      if (dl + 1 == k) {   // If root is at distance k from target, print root
        System.out.print(root.num);
      } else {
        printKDistanceNodeDown(root.right, k - dl - 2);  // Else go to right subtree and print all k-dl-2 distant nodes Note that the right child is 2 edges away from the left child
      }
      return dl + 1;   // Add 1 to the distance and return value for parent calls
    }
    // Mirror of the above code for right subtree. Note that we reach here only when root was not found in left subtree.
    int dr = printKDistanceNode(root.right, target, k);
    if (dr != -1) {
      if (dr + 1 == k) {
        System.out.print(root.num);
      } else {
        printKDistanceNodeDown(root.left, k - dr - 2);
      }
      return dr + 1;
    }
    return -1;   // If target was neither present in left nor in right subtree
  }

  private static void printKDistanceNodeDown(Node root, int level) {
    if (root == null || level < 0) {
      return;
    }
    if (level == 0) {
      System.out.println(root.num);
      return;
    }
    printKDistanceNodeDown(root.left, level - 1);
    printKDistanceNodeDown(root.right, level - 1);
  }

  public static void main(String[] args) {
        /*
                               1
                             /   \
                            2     3
                           / \
                          4    5
                         / \  / \
                        6  7  8 9
        */
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.left.left.left = new Node(6);
    root.left.left.right = new Node(7);
    root.left.right.left = new Node(8);
    root.left.right.right = new Node(9);
    printKDistanceNode(root, root.left, 2);
  }
}
