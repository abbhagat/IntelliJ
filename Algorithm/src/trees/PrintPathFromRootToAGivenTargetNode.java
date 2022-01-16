package trees;

import java.util.LinkedList;

// Time complexity: O(n)

public class PrintPathFromRootToAGivenTargetNode {

    private static boolean hasPath(Node root, int target, LinkedList<Integer> list) {
        if (root == null) {
            return false;
        }
        list.add(root.num);
        if (root.num == target) {
            return true;
        }
        if (hasPath(root.left, target, list) || hasPath(root.right, target, list)) {
            return true;
        }
        list.removeLast();
        return false;
    }

    public static void printPath(Node root, int target) {
        LinkedList<Integer> list = new LinkedList<>();
        if (hasPath(root, target, list)) {
            System.out.println(list);
            return;
        }
        System.out.print("No Path");
    }

    public static void main(String[] args) {
        Node root                = new Node(1);
        root.left                = new Node(2);
        root.right               = new Node(3);
        root.left.left           = new Node(4);
        root.left.right          = new Node(5);
        root.right.left          = new Node(6);
        root.right.right         = new Node(7);
        root.right.left.right    = new Node(11);
        printPath(root, 11);
    }
}
