package trees;


/*
        20
      /   \
    8      22
  /  \      \
 4    12      25
     /   \
    10    14

 */

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
        printLeftEdgeNodes(root);
        printRightEdgeNodes(root.right);
    }

    public static void main(String[] args) {
        Node root                  = new Node(20);
        root.left                  = new Node(8);
        root.right                 = new Node(22);
        root.left.left             = new Node(4);
        root.left.right            = new Node(12);
        root.left.right.left       = new Node(10);
        root.left.right.right      = new Node(14);
        root.right.left            = new Node(15);
        root.right.right           = new Node(25);
        root.right.left.left       = new Node(30);
        root.right.left.right      = new Node(17);
        printBoundary(root);
    }
}
