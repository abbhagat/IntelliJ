package trees;

// Time Complexity: The function does a simple traversal of the tree, so the complexity is O(n)

public class PrintLeftViewOfABinaryTree {

    private static int max_level = 0;

    private static void printLeftView(Node root, int level) {
        if (root == null) {
            return;
        }
        if (max_level < level) {
            System.out.print(" " + root.num);
            max_level = level;
        }
        printLeftView(root.left,  level + 1);
        printLeftView(root.right, level + 1);
    }

    public static void main(String[] args) {
        Node root                = new Node(1);
        root.left                = new Node(2);
        root.left.left           = new Node(3);
        root.left.left.left      = new Node(4);
        root.left.left.left.left = new Node(5);
        root.right               = new Node(6);
        printLeftView(root, 1);
    }
}
