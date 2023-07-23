package trees;

import java.util.LinkedList;

public class RootToTargetPathSum {

    public static boolean pathExist(Node root, int sum, int target) {
        if (root == null) {
            return false;
        }
        sum += root.num;
        if (sum == target) {
            return true;
        }
        return pathExist(root.left, sum, target) || pathExist(root.right, sum, target);
    }

    public static boolean rootToTargetPath(Node root, int sum, int target, LinkedList<Integer> list) {
        if (root == null) {
            return false;
        }
        list.add(root.num);
        sum += root.num;
        if (sum == target) {
            return true;
        }
        boolean left  = rootToTargetPath(root.left,  sum, target, list);
        boolean right = rootToTargetPath(root.right, sum, target, list);
        if (left || right) {
            return true;
        }
        list.removeLast();
        return false;
    }

    public static void rootToTargetPaths(Node root, int sum, int target, LinkedList<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.num);
        sum += root.num;
        if (sum == target) {
            return;
        }
        rootToTargetPaths(root.left,  sum, target, list);
        rootToTargetPaths(root.right, sum, target, list);
        list.removeLast();
    }

    public static void main(String[] args) {
         /*
                       4
                      / \
                     2   7
                    / \  /\
                   1  3  6 8
         */

        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(8);

        System.out.println(pathExist(root, 0, 9));
        System.out.println(pathExist(root, 0, 6));

        LinkedList<Integer> list = new LinkedList<>();
        rootToTargetPath(root, 0, 9, list);
        System.out.println(list);
    }
}
