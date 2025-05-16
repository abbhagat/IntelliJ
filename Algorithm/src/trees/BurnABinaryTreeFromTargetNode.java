package trees;

import java.util.LinkedList;
import java.util.Queue;

/**

Input :
                       12
                     /     \
                   13       10
                          /     \
                       14       15
                      /   \     /  \
                     21   24   22   23
target node = 14

Output :
14
21, 24, 10
15, 12
22, 23, 13

Explanation: First node 14 burns, then it gives fire to its neighbors (21, 24, 10) and so on.
             This process continues until the whole tree burns.

First search the target node in a binary tree recursively.
After finding the target node, print it and save its left child(if exist) and right child(if exist) in a queue and return.
Now, get the size of the queue and run while loop. Print elements in the queue.
*/

// Time complexity:  O(N) where N is the number of nodes.
// Space complexity: O(N) for queue
public class BurnABinaryTreeFromTargetNode {

    private static int time;
    private static final Queue<Node> q = new LinkedList<>();

    private static int burnTree(Node root, int target) {
        if (root == null) {
            return -1;
        }
        if (root.num == target) {
            System.out.println(root.num);
            if (root.left != null) {
                q.add(root.left);
            }
            if (root.right != null) {
                q.add(root.right);
            }
            return 0;
        }
        int leftCall = burnTree(root.left, target);
        if (leftCall == 0) {
            printQueue();
            System.out.println(root.num);
            time++;
            if (root.right != null) {
                q.add(root.right);
            }
            return 0;
        }
        int rightCall = burnTree(root.right, target);
        if (rightCall == 0) {
            printQueue();
            System.out.println(root.num);
            time++;
            if (root.left != null) {
                q.add(root.left);
            }
            return 0;
        }
        return -1;
    }

    private static void printQueue() {
        for (int k = q.size(); k > 0; k--) {
            Node root = q.poll();
            System.out.print(root.num + " ");
            if (root.left != null) {
                q.add(root.left);
            }
            if (root.right != null) {
                q.add(root.right);
            }
        }
    }

    public static void main(String[] args) {
        Node root              = new Node(12);
        root.left              = new Node(13);
        root.right             = new Node(10);
        root.right.left        = new Node(14);
        root.right.right       = new Node(15);
        root.right.left.left   = new Node(21);
        root.right.left.right  = new Node(24);
        root.right.right.left  = new Node(22);
        root.right.right.right = new Node(23);
        burnTree(root, 14);
        while (!q.isEmpty()) {
            time++;
            printQueue();
            System.out.println();
        }
        System.out.println("Time taken to burn the tree is : " + time);
        time = 0;
        System.out.println();
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
        root                          = new Node(1);
        root.left                     = new Node(2);
        root.right                    = new Node(3);
        root.left.left                = new Node(4);
        root.left.right               = new Node(5);
        root.right.right              = new Node(6);
        root.left.right.left          = new Node(7);
        root.left.right.right         = new Node(8);
        root.right.right.right        = new Node(9);
        root.right.right.right.right  = new Node(10);
        burnTree(root, 8);
        while (!q.isEmpty()) {
            time++;
            printQueue();
            System.out.println();
        }
        System.out.println("Time taken to burn the tree is : " + time);
    }
}
