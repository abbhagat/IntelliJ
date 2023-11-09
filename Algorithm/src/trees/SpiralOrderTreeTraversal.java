package trees;

import java.util.Deque;
import java.util.LinkedList;

public class SpiralOrderTreeTraversal {

    private static void spiralOrderTreeTraversal(Node root) {
        Deque<Node> q = new LinkedList<>();
        q.addFirst(root);
        boolean flag = true;
        while(!q.isEmpty()) {
            int size = q.size();
            if(flag) {
                while(size != 0) {
                    Node node = q.pollFirst();
                    System.out.print(node.num + " ");
                    if (node.left != null) {
                        q.addLast(node.left);
                    }
                    if (root.right != null) {
                        q.addLast(node.right);
                    }
                    size--;
                }
            }
            else {
                while (size != 0) {
                    Node node = q.pollLast();
                    System.out.print(node.num + " ");
                    if (node.right != null) {
                        q.addFirst(node.right);
                    }
                    if (node.left != null) {
                        q.addFirst(node.left);
                    }
                    size--;
                }
            }
            flag = !flag;
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
