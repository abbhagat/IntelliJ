package trees;

import static java.lang.Integer.max;

public class TreeHeightOfEachNode {

    private static int heightOfEachNode(Node root) {
        if (root == null) {
            return -1;
        }
        int lH = heightOfEachNode(root.left);
        int rH = heightOfEachNode(root.right);
        int heightOfEachNode = max(lH, rH) + 1;
        System.out.println("Height of Node " + root.num + " --> " + heightOfEachNode);
        return heightOfEachNode;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        heightOfEachNode(root);
    }
}
