package trees;

// Time Complexity: O(n) where n is the number of nodes in the given Binary Tree.

/*
                     1
                  /     \
                2        3
               / \
              4  5
             / \
            7   8
 */

public class PrintAllAncestorsOfAGivenNode {

    private static boolean printAllAncestor(Node root, int num) {
        if (root == null) {
            return false;
        }
        if (root.num == num) {
            return true;
        }
        boolean left  = printAllAncestor(root.left , num);
        boolean right = printAllAncestor(root.right, num);
        if (left || right) {
            System.out.print(root.num + " ");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Node root            = new Node(1);
        root.left            = new Node(2);
        root.right           = new Node(3);
        root.left.left       = new Node(4);
        root.left.right      = new Node(5);
        root.left.left.left  = new Node(7);
        root.left.left.right = new Node(8);
        printAllAncestor(root, 2);
        System.out.println();
        printAllAncestor(root, 3);
    }
}
