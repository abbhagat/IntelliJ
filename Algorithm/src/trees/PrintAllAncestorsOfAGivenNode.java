package trees;

// Time Complexity: O(n) where n is the number of nodes in the given Binary Tree.

public class PrintAllAncestorsOfAGivenNode {

    private static boolean printAllAncestor(Node root, int num) {
        if (root == null) {
            return false;
        }
        if (root.num == num) {
            return true;
        }
        if (printAllAncestor(root.left, num) || printAllAncestor(root.right, num)) {
            System.out.println(root.num);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Node root           = new Node(1);
        root.left           = new Node(2);
        root.right          = new Node(3);
        root.left.left      = new Node(4);
        root.left.right     = new Node(5);
        root.left.left.left = new Node(7);
        printAllAncestor(root, 7);
    }
}
