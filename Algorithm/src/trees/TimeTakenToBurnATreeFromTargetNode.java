package trees;

import java.util.LinkedList;
import java.util.Queue;

public class TimeTakenToBurnATreeFromTargetNode {

    private static final Queue<Node> q = new LinkedList<>();
    private static int time;

    private static int burnTree(Node root, int target) {
        if (root == null) {
            return -1;
        }
        if (root.num == target) {
            if (root.left != null) {
                q.add(root.left);
            }
            if (root.right != null) {
                q.add(root.right);
            }
            return 1;
        }
        int leftCall = burnTree(root.left, target);
        if (leftCall == 1) {
            printQueue();
            if (root.right != null) {
                q.add(root.right);
            }
            time++;
            return 1;
        }
        int rightCall = burnTree(root.right, target);
        if (rightCall == 1) {
            printQueue();
            if (root.left != null) {
                q.add(root.left);
            }
            time++;
            return 1;
        }
        return -1;
    }

    private static void printQueue() {
        for (int k = q.size(); k > 0; k--) {
            Node root = q.poll();
            assert root != null;
            if (root.left != null) {
                q.add(root.left);
            }
            if (root.right != null) {
                q.add(root.right);
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
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(8);
        root.right.right.right = new Node(9);
        root.right.right.right.right = new Node(10);
        burnTree(root, 10);
        while (!q.isEmpty()) {
            time++;
            printQueue();
        }
        System.out.println("Time Taken to Burn the Tree is : " + time);
    }
}
