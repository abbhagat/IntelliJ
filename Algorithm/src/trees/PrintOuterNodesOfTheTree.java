package trees;

import java.util.LinkedList;
import java.util.Queue;

public class PrintOuterNodesOfTheTree {

    private static void printOuterNodes(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        Node first = null, last = null;
        boolean flag = true;
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node == null) {
                if (flag) {
                    if (first != null && last == null) {
                        System.out.print(first.num + "\t");
                    }
                    if (last != null) {
                        System.out.print(first.num + "\t" + last.num + "\t");
                    }
                } else {
                    if (first != null && last == null) {
                        System.out.print(first.num + "\t");
                    }
                    if (last != null) {
                        System.out.print(last.num + "\t" + first.num + "\t");
                    }
                }
                flag  = !flag;
                first = null;
                last  = null;
                System.out.println();
            }
            if (node != null) {
                if (first == null) {
                    first = node;
                } else {
                    last = node;
                }
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            } else if (!q.isEmpty()) {
                q.add(null);
            }
        }
    }

    public static void main(String[] args) {
/*
                                1
                            /      \
                           2        3
                         /   \       \
                        4     5       6
                             / \      \
                            7  8       9
                                        \
                                        10
         */
        Node root              = new Node(1);
        root.left              = new Node(2);
        root.right             = new Node(3);
        root.left.left         = new Node(4);
        root.left.right        = new Node(5);
        root.right.right       = new Node(6);
        root.left.right.left   = new Node(7);
        root.left.right.right  = new Node(8);
        root.right.right.right = new Node(9);
        root.right.right.right.right = new Node(10);
        printOuterNodes(root);
    }
}
