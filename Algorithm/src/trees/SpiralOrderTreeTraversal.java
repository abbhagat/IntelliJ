package trees;

import java.util.LinkedList;

public class SpiralOrderTreeTraversal {

    private static void spiralOrderTreeTraversal(Node root) {
        LinkedList<Node> deque = new LinkedList<>();
        deque.addFirst(root);
        boolean flag = true;
        while (!deque.isEmpty()) {
            int qSize = deque.size();
            if (flag) {
                while (qSize != 0) {
                    Node node = deque.pollFirst();
                    System.out.print(node.num + " ");
                    if (node.left != null) {
                        deque.addLast(node.left);
                    }
                    if (node.right != null) {
                        deque.addLast(node.right);
                    }
                    qSize--;
                }
            }
            else {
                while (qSize != 0) {
                    Node node = deque.pollLast();
                    System.out.print(node.num + " ");
                    if (node.right != null) {
                        deque.addFirst(node.right);
                    }
                    if (node.left != null) {
                        deque.addFirst(node.left);
                    }
                    qSize--;
                }
            }
            flag = !flag;
            System.out.println();
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
                                0
         */
        Node root                    = new Node(1);
        root.left                    = new Node(2);
        root.right                   = new Node(3);
        root.left.left               = new Node(4);
        root.left.right              = new Node(5);
        root.right.right             = new Node(6);
        root.left.right.left         = new Node(7);
        root.left.right.right        = new Node(8);
        root.right.right.right       = new Node(9);
        root.right.right.right.right = new Node(0);
        spiralOrderTreeTraversal(root);
    }
}
