package trees;

import java.util.Stack;

// Time Complexity: O(N+M) Here M and N are the number of nodes in the first and second tree respectively.
// Auxiliary Space: O(h1 + h2), Where h1 and h2 are the heights of the first and second tree respectively.

public class CommonNodesInTwoBST {

    private static void commonNodes(Node root1, Node root2) {
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        while (true) {
            if (root1 != null) {
                s1.push(root1);
                root1 = root1.left;
            } else if (root2 != null) {
                s2.push(root2);
                root2 = root2.left;
            } else if (!s1.isEmpty() && !s2.isEmpty()) {
                root1 = s1.peek();
                root2 = s2.peek();
                if (root1.num == root2.num) {
                    System.out.println(root1.num);
                    s1.pop();
                    s2.pop();
                    root1 = root1.right;
                    root2 = root2.right;
                } else if (root1.num < root2.num) {
                    s1.pop();
                    root1 = root1.right;
                    root2 = null;
                } else {
                    s2.pop();
                    root2 = root2.right;
                    root1 = null;
                }
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(3);
        Node root2 = new Node(2);
        root2.left = new Node(1);
        root2.right = new Node(3);
        commonNodes(root1, root2);
    }
}
