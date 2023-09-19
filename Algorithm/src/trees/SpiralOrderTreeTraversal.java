package trees;

import java.util.*;

import static trees.TreeHeight.treeHeight;

public class SpiralOrderTreeTraversal {

    public static void levelOrderTreeTraversal(Node root) {
        int treeHeight = treeHeight(root);
        boolean flag = true;
        for (int i = 0; i <= treeHeight; i++) {
            printLevelOrder(root, i, flag);
            flag = !flag;
        }
    }

    public static void printLevelOrder(Node root, int level, boolean flag) {
        if (root == null) {
            return;
        }
        if (level == 0) {
            System.out.print(root.num + " ");
            return;
        }
        if (flag) {
            printLevelOrder(root.left,  level - 1, true);
            printLevelOrder(root.right, level - 1, true);
        } else {
            printLevelOrder(root.right, level - 1, false);
            printLevelOrder(root.left,  level - 1, false);
        }
    }


    private static void spiralOrderTreeTraversal(Node root) {
        Queue<Node> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        boolean flag = true;
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            root = q.poll();
            if (root == null) {
                if(flag) {
                    list.forEach(x -> System.out.print(x + " "));
                }else {
                    ListIterator<Integer> iterator = list.listIterator(list.size());
                    while(iterator.hasPrevious()) {
                        System.out.print(iterator.previous() + " ");
                    }
                }
                flag = !flag;
                list.clear();
                System.out.println();
            }
            if (root != null) {
                list.add(root.num);
                if (root.left != null) {
                    q.add(root.left);
                }
                if (root.right != null) {
                    q.add(root.right);
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
        spiralOrderTreeTraversal(root);
    }
}
